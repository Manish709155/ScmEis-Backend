package com.scm.eis.entity;

import com.scm.eis.constant.CompanyServices;
import com.scm.eis.constant.CountryEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "company")
@NoArgsConstructor
@Getter
@Setter
public class Company  extends SuperEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
    CompanyServices services;

    @Column(name="company_emailid")
    String companyEmailId;

    @Column(name="password")
    String password;

    @Column(name="mobile_number")
    String mobileNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    CountryEnum countryEnum;

}
