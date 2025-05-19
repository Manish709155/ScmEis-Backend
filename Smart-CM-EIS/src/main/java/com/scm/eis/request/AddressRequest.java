package com.scm.eis.request;
import com.scm.eis.constant.*;
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
    State state;
    AddressType addressType;
}
