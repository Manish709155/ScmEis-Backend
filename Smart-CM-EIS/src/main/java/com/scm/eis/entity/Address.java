package com.scm.eis.entity;

import com.scm.eis.constant.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address extends SuperEntity implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="house_number")
    String HouseNumber;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    City city;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    State state;

    @Column(name = "district")
    @Enumerated(EnumType.STRING)
    District district;

    @Column(name="post_office_name")
    String postOfficeName;

    @Column(name="pin_code")
    String pinCode;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    CountryEnum country;

    @Column(name="police_station")
    String policeStation;

    @Column(name="street_name")
    String streetName;

    @Column(name="apartment_number")
    String apartmentNumber;

    @Column(name="landmark_nbyl")
    String landmarkNBYL;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    User user;

    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Employee employee;

    @Enumerated(value = EnumType.STRING)
    @Column(name="address_type")
    AddressType addressType;

}