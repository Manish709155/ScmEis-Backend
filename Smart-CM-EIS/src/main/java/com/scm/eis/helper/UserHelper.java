package com.scm.eis.helper;

import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.entity.Company;
import com.scm.eis.entity.User;
import com.scm.eis.exception.UserCreateException;
import com.scm.eis.request.UserRequest;
import com.scm.eis.service.CompanyService;
import com.scm.eis.service.UserService;
import com.scm.eis.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserHelper {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService  companyService;


    public User createUser(UserRequest userRequest) throws UserCreateException {
        Optional<User> user= userService.findUserByEmailIdOrMobileNo(userRequest.getEmailId(),userRequest.getMobileNo());
        if(user.isPresent()){
            throw  new UserCreateException();
        }
      else {
        User newUser = new User();

        newUser.setFirstName(userRequest.getFirstName());
        newUser.setMiddleName(userRequest.getMiddleName());
        newUser.setLastName(userRequest.getFirstName());
        newUser.setPassword(userRequest.getPassword());
        newUser.setEmailId(userRequest.getEmailId());
        newUser.setMobileNo(userRequest.getMobileNo());
        newUser.setConsumerId(CommonUtil.generateConsumerId());
        newUser.setRoleType(RoleTypeEnum.USER);
        newUser.setCountryEnum(CountryEnum.INDIA);
        newUser.setGenderType(userRequest.getGenderType());
        Company company=  companyService.findCompanyById(userRequest.getCompanyId());
        newUser.setCreatedOn(LocalDateTime.now());
        newUser.setCompany(company);
        return  userService.createUser(newUser);
    }
    }
}
