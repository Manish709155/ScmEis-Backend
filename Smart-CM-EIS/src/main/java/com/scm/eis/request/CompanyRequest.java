package com.scm.eis.request;

import com.scm.eis.constant.Services;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyRequest implements Serializable {

    String name;

    String location;


    LocalDateTime startTime;


    LocalDateTime closeTime;


    String registrationNumber;


    boolean active;


    LocalDateTime companyFoundationDate;


    String companyFounderName;


    String companyChairMan;


    String companyOwnerName;


    String currentCeo;


    Double companyRevenues;


    Services services;


    boolean deleted;


    String companyEmailId;


    String password;


    String mobileNumber;
}
