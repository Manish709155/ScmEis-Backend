package com.scm.eis.helper;

import com.scm.eis.constant.*;
import com.scm.eis.entity.*;
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

    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistrationRequest userServiceRegistrationRequest) throws  QueryCreatedException {
        Employee employee = employeeService.findByEmployeeCategoryAndEmployeeLevelAndSapCard(userServiceRegistrationRequest.getEmployeeCategory(),userServiceRegistrationRequest.getEmployeeLevel(),userServiceRegistrationRequest.getEmployeeSapCard());
        UserServiceRegistration userServiceRegistration = new UserServiceRegistration();
        userServiceRegistration.setEmployee(employee);
        userServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
        userServiceRegistration.setEmployeeLevel(employee.getEmployeeLevel());
        userServiceRegistration.setTechSolutionsTypes(userServiceRegistration.getTechSolutionsTypes());
        userServiceRegistration.setTicketNumber(CommonUtil.generateTicketNumber());
        userServiceRegistration.setCreatedOn(LocalDateTime.now());
        userServiceRegistration.setQueryUnder(userServiceRegistrationRequest.getQueryUnder());
        userServiceRegistration.setServiceNumber(CommonUtil.generateServiceNumber());
        userServiceRegistration.setSolutionStatus(SolutionStatus.CREATED);
        userServiceRegistration.setSupportChannel(userServiceRegistrationRequest.getSupportChannel());
        userServiceRegistration.setLanguage(userServiceRegistrationRequest.getLanguage());
        userServiceRegistration.setEscalationPriority(userServiceRegistrationRequest.getEscalationPriority());
        userServiceRegistration.setUser(userService.findByActiveTrueAndConsumerId(userServiceRegistrationRequest.getConsumerId()));
        userServiceRegistration.setEmployee(employee);
        return userServiceRegistrationService.createUserServiceRegistration(userServiceRegistration);
    }

    public UserQueryStatus getUserQueryProgress(String ticketNumber){
        UserServiceRegistration userServiceRegistration = userServiceRegistrationService.findByTicketNumberAndActiveTrue(ticketNumber);
        return UserQueryStatus.builder()
                .id(userServiceRegistration.getId())
                .userQueryUpdatedStatus(userServiceRegistration.getSolutionStatus())
                .build();
    }
}
