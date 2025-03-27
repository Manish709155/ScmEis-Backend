package com.scm.eis.controller;

import com.scm.eis.exception.UserCreateException;
import com.scm.eis.helper.UserHelper;
import com.scm.eis.request.CompanyRequest;
import com.scm.eis.request.UserRequest;
import com.scm.eis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v")
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    UserHelper userHelper;

    @PostMapping("create/user")
    public ResponseEntity<Object> creatCompany(@RequestBody UserRequest request){
        try
        {
            return  new ResponseEntity<>(userService.createUser(userHelper.createUser(request)).getId(), HttpStatus.OK);
        }
        catch (UserCreateException exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
