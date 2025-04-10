package com.scm.eis.helper;

import com.scm.eis.entity.Address;
import com.scm.eis.request.AddressRequest;
import com.scm.eis.response.AddressListResponse;
import com.scm.eis.response.AddressResponse;
import com.scm.eis.service.AddressService;
import com.scm.eis.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressHelper {

    @Autowired
    AddressService addressService;

    @Autowired
    CommonUtil commonUtil;

    public Address getEntity(AddressRequest request){
        Address address;
        if (CommonUtil.isValid(request.getId())) {
            address = addressService.findAddressById(request.getId());
        } else {
            address = new Address();
        }
        address.setCity(request.getCity());

        return address;
    }

    public AddressResponse findAddressById(Long addressId){
        Address address= addressService.findAddressById(addressId); // here we have found the company on behalf o company Id;
        AddressResponse response = new AddressResponse();

        response.setId(address.getId());
        response.setCity(address.getCity());

        return response;
    }



    public List<AddressListResponse> findAllAddresses(List<Address> allAddresses){
        List<AddressListResponse> responses= new ArrayList<>();
        List<Address> addresses = addressService.findAllAddresses();
        addresses.forEach(address ->{
            responses.add(AddressListResponse.builder()
                    .id(address.getId())
                    .city(address.getCity())
                    .build());
        } );
        return responses;
    }

}