package com.scm.eis.controller;

import com.scm.eis.exception.UserCreateException;
import com.scm.eis.helper.UserHelper;
import com.scm.eis.request.*;
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
    @PostMapping("/login/user")
    public ResponseEntity<Object> userLogIn(@RequestBody UserLogInRequest request){
        try {
            return  new ResponseEntity<>(userHelper.logInUser(request.getEmailId(),request.getMobileNumber(),request.getPassword()), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("user/forgot-password")
    public ResponseEntity<Object> forgotPassword(@RequestBody UserForgotPasswordRequest request){
        try {
            userHelper.forgotPassword(request.getEmailId(),request.getMobileNumber());
            return  new ResponseEntity<>("Otp has been send succuessfully on your our registered email...!",HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("user/validate-otp")
    public ResponseEntity<Object> validateOtp(@RequestParam String otp){
        try {
            return  new ResponseEntity<>(userHelper.validateOtp(otp), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("user/reset-password")
    public ResponseEntity<Object> resetpassword(@RequestBody UserLogInRequest request){
        try {
            return  new ResponseEntity<>(userHelper.resetPassword(request.getEmailId(),request.getMobileNumber(),request.getPassword()), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
