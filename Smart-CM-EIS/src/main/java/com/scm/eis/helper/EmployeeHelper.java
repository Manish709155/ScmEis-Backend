package com.scm.eis.helper;

import com.scm.eis.constant.CompanyServices;
import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.entity.Company;
import com.scm.eis.entity.Employee;
import com.scm.eis.entity.NationalUniqueIdentifier;
import com.scm.eis.entity.User;
import com.scm.eis.exception.EmployeeCreateException;
import com.scm.eis.exception.UserCreateException;
import com.scm.eis.request.CompanyRequest;
import com.scm.eis.request.EmployeeRequest;
import com.scm.eis.service.NationalUniqueIdentifierService;
import com.scm.eis.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class EmployeeHelper {

    @Autowired
    NationalUniqueIdentifierService nationalUniqueIdentifierService;

    public Employee getEntity(EmployeeRequest request) throws EmployeeCreateException {

        Optional<NationalUniqueIdentifier> nationalUniqueIdentifier = nationalUniqueIdentifierService.findByPanNumberOrAdharNumber(request.getEmpNationalUnIdnRequest().getPanNumber(), request.getEmpNationalUnIdnRequest().getAdharNumber());
        if (nationalUniqueIdentifier.isPresent()) {
            throw new EmployeeCreateException();
        } else {
            NationalUniqueIdentifier newNationalUniqueIdentifier = new NationalUniqueIdentifier();
            Employee employee = new Employee();

            employee.setFirstName(request.getFirstName());
            employee.setMiddleName(request.getMiddleName());
            employee.setLastName(request.getLastName());
            employee.setSapCard(request.getSapCard());
            employee.setSalary(request.getSalary());
            employee.setJoiningDate(request.getJoiningDate());
            employee.setDob(request.getDob());
            employee.setCompanyEmailId(request.getCompanyEmailId());
            employee.setPersonalEmailId(request.getPersonalEmailId());
            employee.setMobileNumber(request.getMobileNumber());
            employee.setPassword(request.getPassword());
            employee.setGenderType(request.getGenderType());
            employee.setAnyDisability(request.getAnyDisability());
            employee.setBloodGroup(request.getBloodGroup());
            employee.setEmployeeDepartment(request.getEmployeeDepartment());
            employee.setEmployeeCategory(request.getEmployeeCategory());
            //employee.setCompanyId(request.getCompanyId());
            employee.setCountryEnum(request.getCountryEnum());

            newNationalUniqueIdentifier.setAdharNumber(request.getEmpNationalUnIdnRequest().getAdharNumber());
            newNationalUniqueIdentifier.setPanNumber(request.getEmpNationalUnIdnRequest().getPanNumber());
            //newNationalUniqueIdentifier.setEmployee(request.getEmpNationalUnIdnRequest().getEmployeeId());

        }
        return null;
    }
}
