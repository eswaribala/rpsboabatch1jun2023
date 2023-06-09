package com.boa.customerapi.mutations;

import com.boa.customerapi.dtos.CorporateInput;
import com.boa.customerapi.dtos.IndividualInput;
import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.models.FullName;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.CorporateService;
import com.boa.customerapi.services.IndividualService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorporateMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CorporateService corporateService;


    public Corporate addCorporate(CorporateInput corporateInput){

        Corporate corporate=Corporate.builder()
                .accountNo(corporateInput.getAccountNo())
                .name(FullName.builder().firstName(corporateInput.getName().getFirstName())
                        .lastName(corporateInput.getName().getLastName())
                        .middleName(corporateInput.getName().getMiddleName()).build()
                )
                .contactNo(corporateInput.getContactNo())

                .email(corporateInput.getEmail())
                .password(corporateInput.getPassword())
                .companyType(corporateInput.getCompanyType())
                .build();

        return this.corporateService.addCorporate(corporate);


    }

    public Corporate updateCorporate(long accountNo, long contactNo){

        return this.corporateService.updateCorporateById(accountNo,contactNo);
    }


    public boolean deleteCorporate(long accountNo){
        return this.corporateService.deleteCorporateById(accountNo);
    }

}
