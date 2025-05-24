package com.scm.eis.serviceImpl;

import com.scm.eis.entity.Address;
import com.scm.eis.repository.AddressRepository;
import com.scm.eis.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findAddressById(Long addressId) {
        return addressRepository.findById(addressId).get();
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findByActiveTrueAndUserId(Long userId) {
        return addressRepository.findByActiveTrueAndUserId(userId);
    }
}