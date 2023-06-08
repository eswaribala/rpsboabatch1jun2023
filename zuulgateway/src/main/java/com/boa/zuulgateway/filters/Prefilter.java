package com.boa.zuulgateway.filters;

import com.boa.zuulgateway.vos.JwtRequest;
import com.boa.zuulgateway.vos.JwtResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Prefilter extends ZuulFilter {
    @Autowired
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    @Value("${authUrl}")
    private String authUrl;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

       //Step: 1

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest servletRequest = ctx.getRequest();
        System.out.println("Entering pre filter........");
        System.out.println( servletRequest.getRemoteAddr());
        System.out.println("PreFilter: " + String.format("%s request to %s",  servletRequest.getMethod(), servletRequest.getRequestURL().toString()));

        //http://localhost:8765/api/customers/individuals/v1.0/?userName=eswari&userPwd=test@123
        Map<String, List<String>> params=ctx.getRequestQueryParams();


        List<String> data =params.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(data.get(0)+","+data.get(1));
        String token="";

        //Redirect to JWT token
        JwtRequest jwtRequest=new JwtRequest();
        jwtRequest.setUserName(data.get(0));
        jwtRequest.setUserPwd(data.get(1));

        //step 2

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity request = new HttpEntity<>(jwtRequest, headers);
            //phase 1 get jwt token
            //synchronous inter service communication
            //http://localhost:9093/signin
	    /*
	     * {
	"userName":"eswari",
	"userPwd":"test@123"
}
	     */
       //step 3
            ResponseEntity<?> authResponse = restTemplate.
                    postForEntity(authUrl + "signin", request, String.class);
            System.out.println(authResponse.getBody().toString());

        }
        catch(Exception exception)
        {
            System.out.println("token : {} Validation failed" + token );
            //Do not route requests
            ctx.setSendZuulResponse(false);
            responseError(ctx, -403, "invalid token");
        }


        return null;
    }



    /**
     * Response Exception Information to Front End
     */
    private void responseError(RequestContext ctx, int code, String message) {
        HttpServletResponse response = ctx.getResponse();
        JwtResponse errResult = new JwtResponse(code+"->"+message);

        ctx.setResponseBody(toJsonString(errResult));
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json;charset=utf-8");
    }
    private String toJsonString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            System.out.println("json Serialization failed"+e);
            return null;
        }
    }

}
