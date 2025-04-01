package com.scm.eis.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLogInRequest {

    String emailId;

    String mobileNumber;

    String password;

}
