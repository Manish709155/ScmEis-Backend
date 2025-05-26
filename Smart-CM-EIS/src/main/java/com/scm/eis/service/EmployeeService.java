package com.scm.eis.service;

import com.scm.eis.constant.EmployeeCategory;
import com.scm.eis.constant.EmployeeDepartment;
import com.scm.eis.constant.EmployeeLevel;
import com.scm.eis.entity.Employee;
import com.scm.eis.entity.User;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    public Optional<Employee> findEmployeeById(Long employeeId);

    List<Employee> getAllEmployee();

    Employee findByEmployeeCategoryAndEmployeeLevelAndSapCard(EmployeeCategory employeeCategory, EmployeeLevel employeeLevel,String sapCard);

    Employee findByEmployeeDepartmentAndActiveTrue(EmployeeDepartment employeeDepartment);

    Optional<Employee> findEmployeeByCompanyEmailIdOrMobileNumberAndPassword(String companyEmailId, String mobileNumber, String password);
}
