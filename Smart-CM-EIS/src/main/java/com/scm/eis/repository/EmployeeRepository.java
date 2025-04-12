package com.scm.eis.repository;

import com.scm.eis.constant.EmployeeCategory;
import com.scm.eis.constant.EmployeeLevel;
import com.scm.eis.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Employee findByEmployeeCategoryAndEmployeeLevel(EmployeeCategory employeeCategory, EmployeeLevel employeeLevel);
}
