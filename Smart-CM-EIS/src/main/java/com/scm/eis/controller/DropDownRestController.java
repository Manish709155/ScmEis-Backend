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
}
