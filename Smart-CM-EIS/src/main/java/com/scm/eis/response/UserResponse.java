package com.scm.eis.response;
import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.GenderEnum;
import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.constant.State;
import com.scm.eis.constant.District;
import com.scm.eis.constant.City;
import lombok.*;
import lombok.experimental.FieldDefaults;
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

    City city;

    State state;

    String houseNo;

    String pinCode;

    District district;

    String panNumber;

    String adharNumber;

}

