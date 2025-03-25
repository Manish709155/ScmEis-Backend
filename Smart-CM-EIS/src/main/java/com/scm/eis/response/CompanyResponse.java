package com.scm.eis.response;

import com.scm.eis.constant.CompanyServices;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
public class CompanyResponse implements Serializable {

    Long id;

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


    CompanyServices services;




}
