package com.scm.eis.controller;

import com.scm.eis.exception.QueryCreatedException;
import com.scm.eis.exception.UserServiceRegistrationCreateException;
import com.scm.eis.helper.UserServiceRegistrationHelper;
import com.scm.eis.request.UserServiceRegistrationRequest;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v")
public class UserServiceRegistrationRestController {

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    UserServiceRegistrationHelper userServiceRegistrationHelper;

    @PostMapping("create/user/service/registration")
    public ResponseEntity<Object> createUserServiceRegistration(@RequestBody UserServiceRegistrationRequest request){
        try
        {
            return  new ResponseEntity<>(userServiceRegistrationService.createUserServiceRegistration(userServiceRegistrationHelper.createUserServiceRegistration(request)).getId(), HttpStatus.OK);
        }
        catch (QueryCreatedException exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("user/query/progress/{ticketNumber}")
    public ResponseEntity<Object> userQueryProgress(@PathVariable("ticketNumber") String ticketNumber){
        return  new ResponseEntity<>(userServiceRegistrationHelper.getUserQueryProgress(ticketNumber), HttpStatus.OK);
    }
}