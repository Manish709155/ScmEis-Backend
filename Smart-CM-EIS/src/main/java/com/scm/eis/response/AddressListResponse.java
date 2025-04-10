package com.scm.eis.response;


import com.scm.eis.constant.AddressType;
import com.scm.eis.constant.City;
import com.scm.eis.constant.District;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
public class AddressListResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;

    String houseNumber;

    City city;

    District district;

    String postOfficeName;

    String pinCode;

    String policeStation;

    String streetName;

    String apartmentNumber;

    String landmarkNBYL;

    AddressType addressType;
}