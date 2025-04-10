package com.scm.eis.helper;

import com.scm.eis.entity.Company;
import com.scm.eis.entity.NationalUniqueIdentifier;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.exception.UserServiceRegistrationCreateException;
import com.scm.eis.request.UserServiceRegistrationRequest;
import com.scm.eis.service.CompanyService;
import com.scm.eis.service.NationalUniqueIdentifierService;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceRegistrationHelper {

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    NationalUniqueIdentifierService nationalUniqueIdentifierService;

    @Autowired
    CompanyService companyService;

    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistrationRequest userServiceRegistrationRequest) throws UserServiceRegistrationCreateException{
        Company company = companyService.findCompanyById(userServiceRegistrationRequest.getCompanyId());

        Optional<NationalUniqueIdentifier> nationalUniqueIdentifier = nationalUniqueIdentifierService
                .findByPanNumberOrAdharNumber(
                        userServiceRegistrationRequest.getEmpNationalUnIdnRequest().getPanNumber(),
                        userServiceRegistrationRequest.getEmpNationalUnIdnRequest().getAdharNumber()
                );
        if (nationalUniqueIdentifier.isPresent()) {
            throw new UserServiceRegistrationCreateException();
        }
        NationalUniqueIdentifier newNationalUniqueIdentifier = new NationalUniqueIdentifier();
        UserServiceRegistration userServiceRegistration = new UserServiceRegistration();
        userServiceRegistration.setQueryType(userServiceRegistrationRequest.getQueryType());
        userServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
        userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
        userServiceRegistration.setTicketNumber(userServiceRegistrationRequest.getTicketNumber());
        userServiceRegistration.setServiceNumber(userServiceRegistrationRequest.getServiceNumber());
        userServiceRegistration.setSolutionStatus(userServiceRegistrationRequest.getSolutionStatus());
        userServiceRegistration.setSupportChannel(userServiceRegistrationRequest.getSupportChannel());
        userServiceRegistration.setLanguage(userServiceRegistrationRequest.getLanguage());
        userServiceRegistration.setQueryInvalidReason(userServiceRegistrationRequest.getQueryInvalidReason());
        userServiceRegistration.setServicePriority(userServiceRegistrationRequest.getServicePriority());

        return userServiceRegistrationService.createUserServiceRegistration(userServiceRegistration);
    }
}
