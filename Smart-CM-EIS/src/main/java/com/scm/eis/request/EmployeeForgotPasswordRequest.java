package com.scm.eis.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeForgotPasswordRequest {

    String personalEmailId;

    String companyEmailId;

    String password;

}
