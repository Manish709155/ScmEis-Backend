package com.scm.eis.controller;

import com.scm.eis.constant.Services;
import com.scm.eis.entity.Company;
import com.scm.eis.helper.CompanyHelper;
import com.scm.eis.request.CompanyRequest;
import com.scm.eis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v")
@CrossOrigin(origins = "*")
public class CompanyRestController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyHelper helper;
// Entity(Table Structure  define/ create)->
// service(Create  Method for required API)->
// ServiceImpl(Service Method implement)->Repository Interface Create

//    ->extends JpaRepo->Method Call ServiceImpl call->
//    DTO(Request and Response)->
//    Helper class->Data Setter and Getter-1.controller layer
//    and creating rest apis and calling service methods
    @PostMapping("create/company")
    public ResponseEntity<Object> creatCompany(@RequestBody CompanyRequest request){

        try
        {
         return  new ResponseEntity<>(companyService.createCompany(helper.getEntity(request)), HttpStatus.OK);// /execute
        }
        catch (RuntimeException exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);// exception
        }
    }




    @GetMapping("/findCompanyById")
    public ResponseEntity<Object> getResponse(@RequestParam  Long companyId){

        try
        {
            return  new ResponseEntity<>(helper.getCompanyResponse(companyId), HttpStatus.OK);// /execute
        }
        catch (RuntimeException exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);// exception
        }
    }


}
