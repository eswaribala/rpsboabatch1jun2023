package com.boa.customerapi.queries;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class IndividualGLQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private IndividualService individualService;


    public List<Individual>  findAllIndividuals(){
        return this.individualService.getAllIndividuals();
    }

    public Individual findIndividualById(long accountNo){
        return this.individualService.getIndividualById(accountNo);
    }

    public List<Individual> findIndividualByEmail(String email){
        return this.individualService.getIndividualByEmail(email);
    }


}
