package com.scm.eis.controller;

import com.scm.eis.constant.*;
import com.scm.eis.util.DropdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/v/dropdown")
public class DropDownRestController {

    @Autowired
    DropdownUtil dropdownUtil;

    @GetMapping(path = "/companyServicesDropdown")
    public ResponseEntity<Object> companyServicesDropdown () {
        return dropdownUtil.getResponseEntity(CompanyServices.class);
    }

    @GetMapping(path = "/techSolutionsTypesDropdown")
    public ResponseEntity<Object> techSolutionsTypesDropdown() {
        return dropdownUtil.getResponseEntity(TechSolutionsTypes.class);
    }

    @GetMapping(path = "/nonTechSolutionsTypesDropdown")
    public ResponseEntity<Object> nonTechSolutionsTypesDropdown() {
        return dropdownUtil.getResponseEntity(NonTechSolutionsTypes.class);
    }

    @GetMapping(path = "/cityDropdown")
    public ResponseEntity<Object> getCityDropdown() {
        return dropdownUtil.getResponseEntity(City.class);
    }

    @GetMapping(path = "/districtDropdown")
    public ResponseEntity<Object> getDistrictDropdown() {
        return dropdownUtil.getResponseEntity(District.class);
    }

    @GetMapping(path = "/stateDropdown")
    public ResponseEntity<Object> getStateDropdown() {
        return dropdownUtil.getResponseEntity(State.class);
    }

    @GetMapping(path = "/addressTypeDropdown")
    public ResponseEntity<Object> getAddressTypeDropdown() {
        return dropdownUtil.getResponseEntity(AddressType.class);
    }

    @GetMapping(path = "/anyDisabilityDropdown")
    public ResponseEntity<Object> getAnyDisabilityDropdown() {
        return dropdownUtil.getResponseEntity(AnyDisability.class);
    }

    @GetMapping(path = "/bloodGroupDropdown")
    public ResponseEntity<Object> getBloodGroupDropdown() {
        return dropdownUtil.getResponseEntity(BloodGroup.class);
    }

    @GetMapping(path = "/employeeCategoryDropdown")
    public ResponseEntity<Object> getEmployeeCategoryDropdown() {
        return dropdownUtil.getResponseEntity(EmployeeCategory.class);
    }

    @GetMapping(path = "/employeeDepartmentDropdown")
    public ResponseEntity<Object> getEmployeeDepartmentDropdown() {
        return dropdownUtil.getResponseEntity(EmployeeDepartment.class);
    }

    @GetMapping(path = "/genderEnumDropdown")
    public ResponseEntity<Object> getGenderEnumDropdown() {
        return dropdownUtil.getResponseEntity(GenderEnum.class);
    }

    @GetMapping(path = "/languageTypeDropdown")
    public ResponseEntity<Object> getLanguageTypeDropdown() {
        return dropdownUtil.getResponseEntity(LanguageType.class);
    }

    @GetMapping(path = "/queryTypeDropdown")
    public ResponseEntity<Object> getQueryTypeDropdown() {
        return dropdownUtil.getResponseEntity(QueryType.class);
    }

    @GetMapping(path = "/roleTypeEnumDropdown")
    public ResponseEntity<Object> getRoleTypeEnumDropdown() {
        return dropdownUtil.getResponseEntity(RoleTypeEnum.class);
    }

    @GetMapping(path = "/socialMediaCommunicationDropdown")
    public ResponseEntity<Object> getSocialMediaCommunicationDropdown() {
        return dropdownUtil.getResponseEntity(SocialMediaCommunication.class);
    }

    @GetMapping(path = "/solutionStatusDropdown")
    public ResponseEntity<Object> getSolutionStatusDropdown() {
        return dropdownUtil.getResponseEntity(SolutionStatus.class);
    }
}
