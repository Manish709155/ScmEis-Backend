package com.scm.eis.request;

import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.GenderEnum;
import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.entity.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest implements Serializable {

    String firstName;

    String middleName;

    String lastName;

    String password;

    String emailId;

    String mobileNo;

//    RoleTypeEnum roleType; TODO IN FUTURE

     GenderEnum genderType;

     Long companyId;

    EmpNationalUnIdnRequest empNationalUnIdnRequest;

//    CountryEnum countryEnum; TODO IN FUTURE

}
