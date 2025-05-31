package com.scm.eis.controller;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.exception.EmployeeCreateException;
import com.scm.eis.exception.UserCreateException;
import com.scm.eis.helper.EmployeeHelper;
import com.scm.eis.helper.UserHelper;
import com.scm.eis.request.*;
import com.scm.eis.response.EmployeeLoginResponse;
import com.scm.eis.service.EmployeeService;
import com.scm.eis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/login/employee")
    public ResponseEntity<?> employeeLogIn(
            @RequestParam(required = false) String companyEmailId,
            @RequestParam(required = false) String sapCard,
            @RequestParam(required = true) String password) {
        try{
            EmployeeLoginResponse response = employeeHelper.logInEmployee(companyEmailId,sapCard,password);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("findByEmployeeId")
    public ResponseEntity<Object> findById(@RequestParam Long id){
        try{
            return new ResponseEntity<>(employeeHelper.getresponse(employeeService.findEmployeeById(id)),  HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getAllEmployee")
    public ResponseEntity<Object> getAllEmployee(){
        try{
            return new ResponseEntity<>(employeeHelper.getAllEmployee(employeeService.getAllEmployee()),  HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("update/employee")
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeUpdateRequest request){
        try
        {
            employeeHelper.updateEmployeeContact(request).getId();
            return new ResponseEntity<>("EmailId and mobile number updated successfully.", HttpStatus.OK);
        }
        catch (RuntimeException exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("employee/reset-password")
    public ResponseEntity<Object> resetpassword(@RequestBody EmployeeResetPasswordRequest request){
        try {
            return  new ResponseEntity<>(employeeHelper.resetPassword(request.getSapCard(),request.getCompanyEmailId(),request.getPassword()), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}
