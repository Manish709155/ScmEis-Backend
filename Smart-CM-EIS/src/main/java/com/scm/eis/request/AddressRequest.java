package com.scm.eis.request;

import com.scm.eis.constant.*;
import com.scm.eis.entity.Employee;
import com.scm.eis.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressRequest implements Serializable {

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
