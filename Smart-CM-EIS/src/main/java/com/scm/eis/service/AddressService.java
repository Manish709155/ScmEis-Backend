package com.scm.eis.service;

import com.scm.eis.entity.Address;

import java.util.List;

public interface AddressService {

    public Address createAddress(Address address);

    public Address findAddressById(Long addressId);

    List<Address> findAllAddresses();
}