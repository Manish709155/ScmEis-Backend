package com.scm.eis.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserForgotPasswordRequest {

    String emailId;

    String mobileNumber;

//    String password;

}