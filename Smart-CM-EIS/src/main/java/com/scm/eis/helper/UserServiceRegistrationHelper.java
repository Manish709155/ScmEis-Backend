package com.scm.eis.helper;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.Employee;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.exception.QueryCreatedException;
import com.scm.eis.request.UserServiceRegistrationRequest;
import com.scm.eis.response.NotificationResponse;
import com.scm.eis.response.UserQueryStatus;
import com.scm.eis.service.EmployeeService;
import com.scm.eis.service.UserService;
import com.scm.eis.service.UserServiceRegistrationService;
import com.scm.eis.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserServiceRegistrationHelper {

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistrationRequest userServiceRegistrationRequest) throws QueryCreatedException {
        Employee employee = employeeService.findByEmployeeCategoryAndEmployeeLevelAndSapCard(
                userServiceRegistrationRequest.getEmployeeCategory(),
                userServiceRegistrationRequest.getEmployeeLevel(),
                userServiceRegistrationRequest.getEmployeeSapCard()
        );
        Optional<UserServiceRegistration> userServiceRegistration = userServiceRegistrationService.findByConsumerIdAndActiveTrueAndSolutionStatus(
                userServiceRegistrationRequest.getConsumerId()
        );

        if (userServiceRegistration.isPresent()) {
            throw new QueryCreatedException(userServiceRegistration.get().getSolutionStatus());
        }
        UserServiceRegistration newUserServiceRegistration = new UserServiceRegistration();
        if (userServiceRegistrationRequest.getTechSolutionsTypes() != null) {
            newUserServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
        }
        if (userServiceRegistrationRequest.getNonTechSolutionsTypes() != null) {
            newUserServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
        }
        newUserServiceRegistration.setEmployee(employee);
        newUserServiceRegistration.setEmployeeLevel(employee.getEmployeeLevel());
        newUserServiceRegistration.setTicketNumber(CommonUtil.generateTicketNumber());
        newUserServiceRegistration.setCreatedOn(LocalDateTime.now());
        newUserServiceRegistration.setQueryUnder(userServiceRegistrationRequest.getQueryUnder());
        newUserServiceRegistration.setServiceNumber(CommonUtil.generateServiceNumber());
        newUserServiceRegistration.setSolutionStatus(SolutionStatus.CREATED);
        newUserServiceRegistration.setSupportChannel(userServiceRegistrationRequest.getSupportChannel());
        newUserServiceRegistration.setLanguage(userServiceRegistrationRequest.getLanguage());
        newUserServiceRegistration.setUserAskedQuery(userServiceRegistrationRequest.getUserAskedQuery());
        newUserServiceRegistration.setEscalationPriority(userServiceRegistrationRequest.getEscalationPriority());
        newUserServiceRegistration.setUser(
                userService.findByActiveTrueAndConsumerId(userServiceRegistrationRequest.getConsumerId())
        );
        return userServiceRegistrationService.createUserServiceRegistration(newUserServiceRegistration);
    }


    public UserQueryStatus getUserQueryProgress(String ticketNumber){
        UserServiceRegistration userServiceRegistration = userServiceRegistrationService.findByTicketNumberAndActiveTrue(ticketNumber);
        return UserQueryStatus.builder()
                .id(userServiceRegistration.getId())
                .userQueryUpdatedStatus(userServiceRegistration.getSolutionStatus())
                .build();
    }

    public NotificationResponse getNotification(String consumerId){
        NotificationResponse notificationResponse = new NotificationResponse();
       Optional<UserServiceRegistration> usrSerReg= userServiceRegistrationService.findByNotificationReadActiveTrueAndConsumerId(consumerId);
        notificationResponse.setNotificationRead(usrSerReg.get().getNotificationRead());
        notificationResponse.setId(usrSerReg.get().getId());
        notificationResponse.setNotificationMessage(usrSerReg.get().getSolutionStatus());
        return notificationResponse;
    }
}
