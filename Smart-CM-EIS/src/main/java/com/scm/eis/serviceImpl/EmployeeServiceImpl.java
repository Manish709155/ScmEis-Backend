package com.scm.eis.serviceImpl;

import com.scm.eis.constant.EmployeeCategory;
import com.scm.eis.constant.EmployeeLevel;
import com.scm.eis.entity.Employee;
import com.scm.eis.repository.EmployeeRepository;
import com.scm.eis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee) ;
    }

    @Override
    public Optional<Employee> findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByEmployeeCategoryAndEmployeeLevel(EmployeeCategory employeeCategory, EmployeeLevel employeeLevel) {
        return employeeRepository.findByEmployeeCategoryAndEmployeeLevel(employeeCategory,employeeLevel);
    }


}
