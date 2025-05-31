package com.scm.eis.serviceImpl;

import com.scm.eis.constant.EmployeeCategory;
import com.scm.eis.constant.EmployeeDepartment;
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
    public Employee findByEmployeeCategoryAndEmployeeLevelAndSapCard(EmployeeCategory employeeCategory, EmployeeLevel employeeLevel,String sapCard) {
        return employeeRepository.findByEmployeeCategoryAndEmployeeLevelAndSapCard(employeeCategory,employeeLevel,sapCard);
    }

    @Override
    public Employee findByEmployeeDepartmentAndActiveTrue(EmployeeDepartment employeeDepartment) {
        return employeeRepository.findByEmployeeDepartmentAndActiveTrue(employeeDepartment);
    }

    @Override
    public Optional<Employee> findEmployeeByCompanyEmailIdOrMobileNumberAndPassword(String companyEmailId, String mobileNumber, String password) {
        return employeeRepository.findEmployeeByCompanyEmailIdOrMobileNumberAndPassword(companyEmailId,mobileNumber,password);
    }

    @Override
    public Optional<Employee> findEmployeeByPersonalEmailIdOrCompanyEmailIdAndPassword(String personalEmailId,String companyEmailId, String password) {
        return employeeRepository.findEmployeeByPersonalEmailIdOrCompanyEmailIdAndPassword(personalEmailId,companyEmailId, password);
    }


}
