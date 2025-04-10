package com.scm.eis.controller;

import com.scm.eis.helper.AddressHelper;
import com.scm.eis.request.AddressRequest;
import com.scm.eis.service.AddressService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v")
@CrossOrigin(origins = "*")
public class AddressRestController {

    @Autowired
    AddressService addressService;

    @Autowired
    AddressHelper addressHelper;

    @GetMapping("findAddressById")
    public ResponseEntity<Object> findAddressById(@RequestParam Long id){
        try{
            return new ResponseEntity<>(addressHelper.findAddressById(id),  HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getAllAddresses")
    public ResponseEntity<Object> findAllAddresses(){
        try{
            return new ResponseEntity<>(addressHelper.findAllAddresses(addressService.findAllAddresses()),  HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}