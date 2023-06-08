package com.boa.customerapi.services;

import com.boa.customerapi.models.Address;
import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.models.Customer;
import com.boa.customerapi.repositories.AddressRepository;
import com.boa.customerapi.repositories.CorporateRepository;
import com.boa.customerapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;

    //insert

    public Address addAddress(Address address, long accountNo){

        Customer customer =this.customerRepository.findById(accountNo).orElse(null);
        if(customer!=null) {
            address.setCustomer(customer);
            return addressRepository.save(address);
        }
        else
        {
            return  null;
        }
    }

    //select all

    public List<Address> getAllAddresses(){
        return this.addressRepository.findAll();

    }



    //where

    public List<Address> getAddressById(long accountNo){


        return this.addressRepository.findAddressByAccountNo(accountNo);
    }


    //update

    public Address updateAddressById(long accountNo, String doorNo, String city){

        List<Address> addressList=this.addressRepository.findAddressByAccountNo(accountNo);
        Address address =addressList.stream().filter(a->a.getDoorNo()== doorNo).findFirst().orElse(null);
        if(address !=null) {
            address.setCity(city);
            this.addressRepository.save(address);
            return address;
        }
        else
            return null;
    }


    //delete

    public boolean deleteAddressById(long accountNo,String doorNo){
        boolean status=false;
        List<Address> addressList=this.addressRepository.findAddressByAccountNo(accountNo);
        Address address =addressList.stream().filter(a->a.getDoorNo()== doorNo).findFirst().orElse(null);
        if(address !=null) {
            this.addressRepository.deleteById(address.getAddressId());
            status=true;
        }

        return status;

    }
}
