package com.scm.eis.response;

import com.scm.eis.constant.CompanyServices;
import com.scm.eis.constant.CountryEnum;
import com.scm.eis.entity.Company;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class CompanyListResponse implements Serializable {

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

        String companyEmailId;

        String password;

        String mobileNumber;

        CountryEnum countryEnum;

}


