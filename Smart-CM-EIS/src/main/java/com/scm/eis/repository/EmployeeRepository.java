package com.scm.eis.repository;

import com.scm.eis.constant.EmployeeCategory;
import com.scm.eis.constant.EmployeeDepartment;
import com.scm.eis.constant.EmployeeLevel;
import com.scm.eis.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Employee findByEmployeeCategoryAndEmployeeLevelAndSapCard(EmployeeCategory employeeCategory, EmployeeLevel employeeLevel,String sapCard);

    Employee findByEmployeeDepartmentAndActiveTrue(EmployeeDepartment employeeDepartment);

    Optional<Employee> findEmployeeByCompanyEmailIdOrMobileNumberAndPassword(String companyEmailId, String mobileNumber, String password);

    Optional<Employee> findEmployeeByPersonalEmailIdOrCompanyEmailIdAndPassword(String personalEmailId, String companyEmailId, String password);
}
