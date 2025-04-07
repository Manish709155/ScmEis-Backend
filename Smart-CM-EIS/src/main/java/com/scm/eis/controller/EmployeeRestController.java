package com.scm.eis.controller;

import com.scm.eis.exception.EmployeeCreateException;
import com.scm.eis.exception.UserCreateException;
import com.scm.eis.helper.EmployeeHelper;
import com.scm.eis.helper.UserHelper;
import com.scm.eis.request.EmployeeRequest;
import com.scm.eis.request.UserRequest;
import com.scm.eis.service.EmployeeService;
import com.scm.eis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/v")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeHelper employeeHelper;

    @PostMapping("create/employee")
    public ResponseEntity<Object> createCompany(@RequestBody EmployeeRequest request){
        try
        {
            return  new ResponseEntity<>(employeeService.createEmployee(employeeHelper.getEntity(request)).getId(), HttpStatus.OK);
        }
        catch (EmployeeCreateException exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
