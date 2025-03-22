package com.scm.eis.entity;

import com.scm.eis.constant.Services;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Table(name="company")
@Setter
@Getter
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name")
    String name;

    @Column(name="location")
    String location;

    @Column(name="start_time")
    LocalDateTime  startTime;

    @Column(name="close_time")
    LocalDateTime closeTime;

    @Column(name="registration_number")
    String registrationNumber;

    @Column(name="active")
    Boolean active =Boolean.TRUE;

    @Column(name="company_foundation_date")
    LocalDateTime companyFoundationDate;

    @Column(name="company_founder_name")
    String companyFounderName;

    @Column(name="company_chair_man")
    String companyChairMan;

    @Column(name="company_owner_name")
    String companyOwnerName;

    @Column(name="current_ceo")
    String currentCeo;

    @Column(name="company_revenues")
    Double companyRevenues;

    @Enumerated(value = EnumType.STRING)
    @Column(name="services")
    Services services;

    @Column(name="deleted")
    Boolean deleted =Boolean.FALSE;

    @Column(name="company_emailid")
    String companyEmailId;

    @Column(name="password")
    String password;

    @Column(name="mobile_number")
    String mobileNumber;

}
