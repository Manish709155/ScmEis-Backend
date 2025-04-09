package com.scm.eis.helper;

import com.scm.eis.constant.CompanyServices;
import com.scm.eis.constant.CountryEnum;
import com.scm.eis.entity.Company;
import com.scm.eis.entity.User;
import com.scm.eis.request.CompanyRequest;
import com.scm.eis.response.CompanyListResponse;
import com.scm.eis.response.CompanyResponse;
import com.scm.eis.response.UserListResponse;
import com.scm.eis.service.CompanyService;
import com.scm.eis.util.CommonUtil;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CompanyHelper {

    @Autowired
    CompanyService companyService;

    @Autowired
    CommonUtil commonUtil;


    public Company getEntity(CompanyRequest request) {
        Company company;
        if (CommonUtil.isValid(request.getId())) {
            company = companyService.findCompanyById(request.getId());
        } else {
            company = new Company();
        }
        company.setName(request.getName());
        company.setLocation(request.getLocation());
        company.setStartTime(request.getStartTime());
        company.setCloseTime(request.getCloseTime());
        company.setRegistrationNumber(request.getRegistrationNumber());
        company.setCompanyFoundationDate(request.getCompanyFoundationDate());
        company.setCompanyFounderName(request.getCompanyFounderName());
        company.setCompanyChairMan(request.getCompanyChairMan());
        company.setCompanyOwnerName(request.getCompanyOwnerName());
        company.setCurrentCeo(request.getCurrentCeo());
        company.setCompanyRevenues(request.getCompanyRevenues());
        company.setServices(CompanyServices.BOTH);
        company.setCompanyEmailId(request.getCompanyEmailId());
        company.setPassword(request.getPassword());
        company.setMobileNumber(request.getMobileNumber());
        company.setCreatedOn(LocalDateTime.now());
        company.setCountryEnum(CountryEnum.INDIA);
        return company;
    }

    public CompanyResponse getCompanyResponse(Long companyId) {
        Company company = companyService.findCompanyById(companyId); // here we have found the company on behalf o company Id;
        CompanyResponse response = new CompanyResponse();

        response.setId(company.getId());
        response.setLocation(company
                .getLocation());
        response.setName(company.getName());

        return response;

    }

    public List<CompanyListResponse> getCompanyList(List<Company> company) {
        List<CompanyListResponse> responses = new ArrayList<CompanyListResponse>();
        company.forEach(com -> {
            responses.add(CompanyListResponse.builder()
                    .id(com.getId())
                    .name(com.getName())
                    .location(com.getLocation())
                    .startTime(com.getStartTime())
                    .closeTime(com.getCloseTime())
                    .registrationNumber(com.getRegistrationNumber())
                    .companyFoundationDate(com.getCompanyFoundationDate())
                    .companyChairMan(com.getCompanyChairMan())
                    .companyOwnerName(com.getCompanyOwnerName())
                    .currentCeo(com.getCurrentCeo())
                    .companyRevenues(com.getCompanyRevenues())
                    .services(com.getServices())
                    .companyEmailId(com.getCompanyEmailId())
                    .password(com.getPassword())
                    .mobileNumber(com.getMobileNumber())
                    .countryEnum(com.getCountryEnum())
                    .build());
        });
        return responses;
    }
}