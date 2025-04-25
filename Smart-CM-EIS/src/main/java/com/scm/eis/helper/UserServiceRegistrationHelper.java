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
        Employee employee = employeeService.findByEmployeeCategoryAndEmployeeLevel(EmployeeCategory.TECHNICAL,userServiceRegistrationRequest.getEmployeeLevel());
        Employee employee2 = employeeService.findByEmployeeCategoryAndEmployeeLevel(EmployeeCategory.NONTECHNICAL,userServiceRegistrationRequest.getEmployeeLevel());
        Employee queryAssignedEmployeeDepartment = employeeService.findByEmployeeDepartmentAndActiveTrue(userServiceRegistrationRequest.getQueryAssignToEmployeeDepartment());
        Optional<UserServiceRegistration> userServiceRegistrationOptional = userServiceRegistrationService.findByTicketNumberAndActiveAndInSolutionStatusInList(userServiceRegistrationRequest.getTicketNumber(), Boolean.TRUE, Arrays.asList(userServiceRegistrationRequest.getSolutionStatus()));
        if(userServiceRegistrationOptional.isPresent()){
            throw new QueryCreatedException(userServiceRegistrationRequest.getSolutionStatus()) ;
        }
        UserServiceRegistration userServiceRegistration = new UserServiceRegistration();

        if(userServiceRegistrationRequest.getQueryType()== QueryType.INVALID){
            userServiceRegistration.setQueryInvalidReason(userServiceRegistrationRequest.getQueryInvalidReason());
            userServiceRegistration.setQueryType(QueryType.INVALID);
        }
        else{
            userServiceRegistration.setQueryType(QueryType.VALID);
        }
        if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_ONE)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.VERY_HIGH);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_TWO)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.HIGH);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_THREE)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.MEDIUM);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_FOUR)){
            userServiceRegistration.setTechSolutionsTypes(userServiceRegistrationRequest.getTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.LOW);
        }
        else if (userServiceRegistrationRequest.getTechSolutionsTypes()== TechSolutionsTypes.OPTION_NOT_AVAILABLE && employee.getEmployeeLevel().equals(userServiceRegistrationRequest.getEmployeeLevel())){
            userServiceRegistration.setOptionNotAvailable(userServiceRegistrationRequest.getOptionNotAvailable());
            userServiceRegistration.setEscalationPriority(userServiceRegistrationRequest.getEscalationPriority());
        }

        if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.NON_TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_ONE)){
            userServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.VERY_HIGH);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.NON_TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_TWO)){
            userServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.HIGH);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.NON_TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_THREE)){
            userServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.MEDIUM);
        }
        else if(userServiceRegistrationRequest.getQueryUnder() == QueryUnder.NON_TECHNICAL && employee.getEmployeeLevel().equals(EmployeeLevel.LEVEL_FOUR)){
            userServiceRegistration.setNonTechSolutionsTypes(userServiceRegistrationRequest.getNonTechSolutionsTypes());
            userServiceRegistration.setEscalationPriority(EscalationPriority.LOW);
        }
        else if (userServiceRegistrationRequest.getTechSolutionsTypes()== TechSolutionsTypes.OPTION_NOT_AVAILABLE && employee.getEmployeeLevel().equals(userServiceRegistrationRequest.getEmployeeLevel())){
            userServiceRegistration.setOptionNotAvailable(userServiceRegistrationRequest.getOptionNotAvailable());
            userServiceRegistration.setEscalationPriority(userServiceRegistrationRequest.getEscalationPriority());
        }
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
        userServiceRegistration.setEmployee(employee2);
        userServiceRegistration.setQueryAssignToEmployeeDepartment(queryAssignedEmployeeDepartment.getEmployeeDepartment());
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
