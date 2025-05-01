package com.scm.eis.request;

import com.scm.eis.constant.*;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class EmployeeRequest implements Serializable {

    static final long serialVersionUID = 1L;

    String firstName;

    String middleName;

    String lastName;

    BigDecimal salary;

    LocalDateTime joiningDate;

    LocalDateTime dob;

    String companyEmailId;

    String personalEmailId;

    String mobileNumber;

    String password;

    GenderEnum genderType;

    AnyDisability anyDisability;

    BloodGroup bloodGroup;

    EmployeeDepartment employeeDepartment;

    EmployeeCategory employeeCategory;

    Long companyId;

    CountryEnum countryEnum;

    EmpNationalUnIdnRequest empNationalUnIdnRequest;

    AddressRequest addressRequest;

    EmployeeLevel employeeLevel;

}
