package com.boa.zuulgateway.filters;

import com.boa.zuulgateway.vos.JwtRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Prefilter extends ZuulFilter {
    @Autowired
    private RestTemplate restTemplate;

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



        return null;
    }
}
