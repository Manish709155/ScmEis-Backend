package com.scm.eis.helper;

import com.scm.eis.entity.Company;
import com.scm.eis.request.CompanyRequest;
import com.scm.eis.response.CompanyResponse;
import com.scm.eis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CompanyHelper {

    @Autowired
    CompanyService companyService;

    public Company getEntity(CompanyRequest request){
        Company company = new Company();
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
        company.setServices(request.getServices());
        company.setCompanyEmailId(request.getCompanyEmailId());
        company.setPassword(request.getPassword());
        company.setMobileNumber(request.getMobileNumber());
        company.setCreatedOn(LocalDateTime.now());
        return company;
    }

    public CompanyResponse getCompanyResponse(Long companyId){
       Company company= companyService.findCompanyById(companyId); // here we have found the company on behalf o company Id;
        CompanyResponse response = new CompanyResponse();

        response.setId(company.getId());
        response.setLocation(company
                .getLocation());
    response.setName(company.getName());

        return response;

    }
}
