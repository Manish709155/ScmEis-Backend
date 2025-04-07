package com.scm.eis.serviceImpl;

import com.scm.eis.entity.Employee;
import com.scm.eis.repository.EmployeeRepository;
import com.scm.eis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee) ;
    }
}
