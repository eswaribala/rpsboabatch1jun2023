package com.boa.customerapi.mutations;

import com.boa.customerapi.dtos.IndividualInput;
import com.boa.customerapi.models.FullName;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndividualMutationResolver implements GraphQLMutationResolver {


    @Autowired
    private IndividualService individualService;


   public Individual addIndividual(IndividualInput individualInput){

       Individual individual=Individual.builder()
               .accountNo(individualInput.getAccountNo())
               .name(FullName.builder().firstName(individualInput.getName().getFirstName())
                       .lastName(individualInput.getName().getLastName())
                       .middleName(individualInput.getName().getMiddleName()).build()
               )
               .contactNo(individualInput.getContactNo())
               .dob(individualInput.getDob())
               .email(individualInput.getEmail())
               .password(individualInput.getPassword())
               .gender(individualInput.getGender()).build();

       return this.individualService.addIndividual(individual);


   }

   public Individual updateIndividual(long accountNo, long contactNo){

       return this.individualService.updateIndividualById(accountNo,contactNo);
   }


   public boolean deleteIndividual(long accountNo){
       return this.individualService.deleteIndividualById(accountNo);
   }

}
