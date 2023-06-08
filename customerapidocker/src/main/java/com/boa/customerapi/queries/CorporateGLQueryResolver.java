package com.boa.customerapi.queries;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorporateGLQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CorporateService corporateService;

    public List<Corporate> findAllCorporates(){
        return this.corporateService.getAllCorporates();
    }

    public Corporate findCorporateById(long accountNo){
        return this.findCorporateById(accountNo);
    }

}
