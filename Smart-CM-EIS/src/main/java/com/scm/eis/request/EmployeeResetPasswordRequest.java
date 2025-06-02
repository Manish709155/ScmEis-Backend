package com.scm.eis.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResetPasswordRequest {

    String companyEmailId;

    String sapCard;

    String password;

}
