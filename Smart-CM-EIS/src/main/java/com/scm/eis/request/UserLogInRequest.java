package com.scm.eis.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserLogInRequest {

    String emailId;

    String mobileNumber;

    String password;

}
