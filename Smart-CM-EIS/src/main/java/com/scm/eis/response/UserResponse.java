package com.scm.eis.response;

import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.GenderEnum;
import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.entity.Company;
import com.scm.eis.entity.UserServiceRegistration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;

    String firstName;

    String middleName;

    String lastName;

    String emailId;

    String mobileNo;

    String consumerId;

    RoleTypeEnum roleType;

    GenderEnum genderType;

    CountryEnum countryEnum;

}

