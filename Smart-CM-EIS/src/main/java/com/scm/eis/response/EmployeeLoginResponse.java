package com.scm.eis.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeLoginResponse {

    Long employeeLoginId;

    String loginSapId;

    String loginResponse;
}
