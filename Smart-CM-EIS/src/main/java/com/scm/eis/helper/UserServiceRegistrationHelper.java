package com.scm.eis.helper;

import com.scm.eis.constant.*;
import com.scm.eis.entity.Company;
import com.scm.eis.entity.Employee;
import com.scm.eis.entity.NationalUniqueIdentifier;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.exception.UserServiceRegistrationCreateException;
import com.scm.eis.request.UserServiceRegistrationRequest;
import com.scm.eis.service.*;
import com.scm.eis.util.CommonUtil;
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

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistrationRequest userServiceRegistrationRequest) throws UserServiceRegistrationCreateException{
        Company company = companyService.findCompanyById(userServiceRegistrationRequest.getCompanyId());
//
//        Optional<NationalUniqueIdentifier> nationalUniqueIdentifier = nationalUniqueIdentifierService
//                .findByPanNumberOrAdharNumber(
//                        userServiceRegistrationRequest.getEmpNationalUnIdnRequest().getPanNumber(),
//                        userServiceRegistrationRequest.getEmpNationalUnIdnRequest().getAdharNumber()
//                );
//        if (nationalUniqueIdentifier.isPresent()) {
//            throw new UserServiceRegistrationCreateException();
//        }
//        NationalUniqueIdentifier newNationalUniqueIdentifier = new NationalUniqueIdentifier();
        UserServiceRegistration userServiceRegistration = new UserServiceRegistration();
        if(userServiceRegistrationRequest.getQueryType()== QueryType.INVALID){
            userServiceRegistration.setQueryInvalidReason(userServiceRegistrationRequest.getQueryInvalidReason());
            userServiceRegistration.setQueryType(QueryType.INVALID);
        }
        else{
            userServiceRegistration.setQueryType(QueryType.VALID);
        }
        Employee employee = employeeService.findByEmployeeCategoryAndEmployeeLevel(EmployeeCategory.TECHNICAL,userServiceRegistrationRequest.getEmployeeLevel());
        if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_ONE)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.VERY_HIGH);
            userServiceRegistration.setEmployee(employee);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_TWO)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.HIGH);
            userServiceRegistration.setEmployee(employee);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_THREE)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.MEDIUM);
            userServiceRegistration.setEmployee(employee);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_FOUR)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.LOW);
            userServiceRegistration.setEmployee(employee);
        }
        else if (userServiceRegistrationRequest.getTechSolutionsTypes()== TechSolutionsTypes.OPTION_NOT_AVAILABLE && employee.getEmployeeLevel().equals(userServiceRegistrationRequest.getEmployeeLevel())){
            userServiceRegistration.setOptionNotAvailable(userServiceRegistrationRequest.getOptionNotAvailable());
            userServiceRegistration.setEscalationPriority(userServiceRegistrationRequest.getEscalationPriority());
            userServiceRegistration.setEmployee(employee);
        }
        Employee employee2 = employeeService.findByEmployeeCategoryAndEmployeeLevel(EmployeeCategory.NONTECHNICAL,userServiceRegistrationRequest.getEmployeeLevel());
        if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.NON_TECHNICAL){
            userServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
            userServiceRegistration.setEmployee(employee2);
        }
        else if (userServiceRegistrationRequest.getNonTechSolutionsTypes()== NonTechSolutionsTypes.OPTION_NOT_AVAILABLE){
            userServiceRegistration.setOptionNotAvailable(userServiceRegistrationRequest.getOptionNotAvailable());
            userServiceRegistration.setEmployee(employee2);
        }
        userServiceRegistration.setTicketNumber(CommonUtil.generateTicketNumber());
        userServiceRegistration.setServiceNumber(CommonUtil.generateServiceNumber());
        userServiceRegistration.setSolutionStatus(SolutionStatus.CREATED);
        userServiceRegistration.setSupportChannel(userServiceRegistrationRequest.getSupportChannel());
        userServiceRegistration.setLanguage(userServiceRegistrationRequest.getLanguage());
        userServiceRegistration.setEscalationPriority(userServiceRegistrationRequest.getEscalationPriority());
        userServiceRegistration.setUser(userService.findByActiveTrueAndConsumerId(userServiceRegistrationRequest.getConsumerId()));
        return userServiceRegistrationService.createUserServiceRegistration(userServiceRegistration);
    }
}
