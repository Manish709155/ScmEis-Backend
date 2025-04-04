package com.scm.eis.response;

import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.GenderEnum;
import com.scm.eis.constant.RoleTypeEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserListResponse {

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
