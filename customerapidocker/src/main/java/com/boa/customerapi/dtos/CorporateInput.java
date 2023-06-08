package com.boa.customerapi.dtos;

import com.boa.customerapi.models.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateInput {
    private long accountNo;

    private FullNameInput name;

    private String email;

    private String password;

    private long contactNo;
    private CompanyType companyType;
}
