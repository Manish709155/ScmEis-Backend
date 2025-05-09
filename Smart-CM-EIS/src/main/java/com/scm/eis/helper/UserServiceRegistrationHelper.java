package com.scm.eis.helper;

import com.scm.eis.constant.*;
import com.scm.eis.entity.*;
import com.scm.eis.exception.EmployeeCreateException;
import com.scm.eis.exception.QueryCreatedException;
import com.scm.eis.exception.UserCreateException;
import com.scm.eis.exception.UserServiceRegistrationCreateException;
import com.scm.eis.request.UserServiceRegistrationRequest;
import com.scm.eis.response.UserQueryStatus;
import com.scm.eis.response.UserResponse;
import com.scm.eis.service.*;
import com.scm.eis.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Component
public class UserServiceRegistrationHelper {

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistrationRequest userServiceRegistrationRequest) throws QueryCreatedException{
        Employee employee = employeeService.findByEmployeeCategoryAndEmployeeLevelAndSapCard(userServiceRegistrationRequest.getEmployeeCategory(),userServiceRegistrationRequest.getEmployeeLevel(),userServiceRegistrationRequest.getEmployeeSapCard());
        Optional<UserServiceRegistration> userServiceRegistration  = userServiceRegistrationService.findByConsumerIdAndActiveTrueAndSolutionStatus(userServiceRegistrationRequest.getConsumerId());

        if (userServiceRegistration.isPresent()) {
            throw new QueryCreatedException(userServiceRegistration.get().getSolutionStatus());
        }
        UserServiceRegistration newUserServiceRegistration = new UserServiceRegistration();
        newUserServiceRegistration.setEmployee(employee);
        newUserServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
        newUserServiceRegistration.setEmployeeLevel(employee.getEmployeeLevel());
        newUserServiceRegistration.setTechSolutionsTypes(newUserServiceRegistration.getTechSolutionsTypes());
        newUserServiceRegistration.setTicketNumber(CommonUtil.generateTicketNumber());
        newUserServiceRegistration.setCreatedOn(LocalDateTime.now());
        newUserServiceRegistration.setQueryUnder(userServiceRegistrationRequest.getQueryUnder());
        newUserServiceRegistration.setServiceNumber(CommonUtil.generateServiceNumber());
        newUserServiceRegistration.setSolutionStatus(SolutionStatus.CREATED);
        newUserServiceRegistration.setSupportChannel(userServiceRegistrationRequest.getSupportChannel());
        newUserServiceRegistration.setLanguage(userServiceRegistrationRequest.getLanguage());
        newUserServiceRegistration.setUserAskedQuery(userServiceRegistrationRequest.getUserAskedQuery());
        newUserServiceRegistration.setEscalationPriority(userServiceRegistrationRequest.getEscalationPriority());
        newUserServiceRegistration.setUser(userService.findByActiveTrueAndConsumerId(userServiceRegistrationRequest.getConsumerId()));
        newUserServiceRegistration.setEmployee(employee);
        return userServiceRegistrationService.createUserServiceRegistration(newUserServiceRegistration);
    }

    public UserQueryStatus getUserQueryProgress(String ticketNumber){
        UserServiceRegistration userServiceRegistration = userServiceRegistrationService.findByTicketNumberAndActiveTrue(ticketNumber);
        return UserQueryStatus.builder()
                .id(userServiceRegistration.getId())
                .userQueryUpdatedStatus(userServiceRegistration.getSolutionStatus())
                .build();
    }
}
