package com.scm.eis.controller;

import com.scm.eis.constant.*;
import com.scm.eis.exception.QueryCreatedException;
import com.scm.eis.helper.UserServiceRegistrationHelper;
import com.scm.eis.request.UserServiceRegistrationRequest;
import com.scm.eis.service.UserService;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v")
public class UserServiceRegistrationRestController {

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    UserServiceRegistrationHelper userServiceRegistrationHelper;

    @Autowired
    UserService  userService;

    @GetMapping("/create/user/service/registration")
    public ResponseEntity<Object> createUserServiceRegistration(
            @RequestParam SolutionStatus solutionStatus,
            @RequestParam SupportChannel supportChannel,
            @RequestParam LanguageType language,
            @RequestParam EscalationPriority escalationPriority,
            @RequestParam QueryUnder queryUnder,
            @RequestParam EmployeeLevel employeeLevel,
            @RequestParam String consumerId,
            @RequestParam EmployeeCategory employeeCategory,
            @RequestParam String userAskedQuery,
            @RequestParam(required = false) TechSolutionsTypes techSolutionsTypes,
            @RequestParam(required = false) NonTechSolutionsTypes nonTechSolutionsTypes
    ) {
        try {
            UserServiceRegistrationRequest request = UserServiceRegistrationRequest.builder()
                    .solutionStatus(solutionStatus)
                    .supportChannel(supportChannel)
                    .language(language)
                    .escalationPriority(escalationPriority)
                    .queryUnder(queryUnder)
                    .employeeLevel(employeeLevel)
                    .consumerId(consumerId)
                    .employeeCategory(employeeCategory)
                    .userAskedQuery(userAskedQuery)
                    .techSolutionsTypes(techSolutionsTypes)
                    .nonTechSolutionsTypes(nonTechSolutionsTypes)
                    .build();
            if (request != null && request.getTechSolutionsTypes() != null && request.getNonTechSolutionsTypes() != null) {
                throw new RuntimeException("Please select either Tech Solution Types or Non-Tech Solution Types, not both.");
            }

            Long registrationId = userServiceRegistrationService.createUserServiceRegistration(
                    userServiceRegistrationHelper.createUserServiceRegistration(request)
            ).getId();

            return new ResponseEntity<>(registrationId, HttpStatus.OK);
        } catch (QueryCreatedException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException runtimeException) {
            return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




    @GetMapping("user/query/progress/{ticketNumber}")
    public ResponseEntity<Object> userQueryProgress(@PathVariable("ticketNumber") String ticketNumber){
        return  new ResponseEntity<>(userServiceRegistrationHelper.getUserQueryProgress(ticketNumber), HttpStatus.OK);
    }
}