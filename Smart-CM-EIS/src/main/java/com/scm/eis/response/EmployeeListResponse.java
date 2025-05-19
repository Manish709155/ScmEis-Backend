package com.scm.eis.response;

import com.scm.eis.constant.*;
import com.scm.eis.request.AddressRequest;
import com.scm.eis.request.EmpNationalUnIdnRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
public class EmployeeListResponse {

    Long id;

    String firstName;

    String middleName;

    String lastName;

    String sapCard;

    BigDecimal salary;

    LocalDateTime joiningDate;

    LocalDateTime dob;

    String companyEmailId;

    String personalEmailId;

    String mobileNumber;

    GenderEnum genderType;

    AnyDisability anyDisability;

    BloodGroup bloodGroup;

    EmployeeDepartment employeeDepartment;

    EmployeeCategory employeeCategory;

    Long companyId;

    CountryEnum countryEnum;

}
