package com.scm.eis.service;

import com.scm.eis.constant.EmployeeCategory;
import com.scm.eis.constant.EmployeeLevel;
import com.scm.eis.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    public Optional<Employee> findEmployeeById(Long employeeId);

    List<Employee> getAllEmployee();

    Employee findByEmployeeCategoryAndEmployeeLevel(EmployeeCategory employeeCategory, EmployeeLevel employeeLevel);
}
