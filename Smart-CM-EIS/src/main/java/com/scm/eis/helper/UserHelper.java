package com.scm.eis.helper;

import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.entity.Company;
import com.scm.eis.entity.NationalUniqueIdentifier;
import com.scm.eis.entity.User;
import com.scm.eis.exception.UserCreateException;
import com.scm.eis.request.UserRequest;
import com.scm.eis.response.UserListResponse;
import com.scm.eis.response.UserResponse;
import com.scm.eis.service.CompanyService;
import com.scm.eis.service.NationalUniqueIdentifierService;
import com.scm.eis.service.UserService;
import com.scm.eis.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserHelper {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService  companyService;

    @Autowired
    NationalUniqueIdentifierService nationalUniqueIdentifierService;


    public User createUser(UserRequest userRequest) throws UserCreateException {
        Company company = companyService.findCompanyById(userRequest.getCompanyId());

        Optional<NationalUniqueIdentifier> nationalUniqueIdentifier = nationalUniqueIdentifierService
                .findByPanNumberOrAdharNumber(
                        userRequest.getEmpNationalUnIdnRequest().getPanNumber(),
                        userRequest.getEmpNationalUnIdnRequest().getAdharNumber()
                );
        if (nationalUniqueIdentifier.isPresent()) {
            throw new UserCreateException();
        }
        NationalUniqueIdentifier newNationalUniqueIdentifier = new NationalUniqueIdentifier();
        User newUser = new User();
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setMiddleName(userRequest.getMiddleName());
        newUser.setLastName(userRequest.getLastName());
        newUser.setPassword(userRequest.getPassword());
        newUser.setEmailId(userRequest.getEmailId());
        newUser.setMobileNo(userRequest.getMobileNo());
        newUser.setConsumerId(CommonUtil.generateConsumerId());
        newUser.setRoleType(RoleTypeEnum.USER);
        newUser.setCountryEnum(CountryEnum.INDIA);
        newUser.setGenderType(userRequest.getGenderType());
        newUser.setCreatedOn(LocalDateTime.now());
        newUser.setCompany(company);
        newNationalUniqueIdentifier.setAdharNumber(userRequest.getEmpNationalUnIdnRequest().getAdharNumber());
        newNationalUniqueIdentifier.setPanNumber(userRequest.getEmpNationalUnIdnRequest().getPanNumber());
        newNationalUniqueIdentifier.setCreatedOn(LocalDateTime.now());
        newNationalUniqueIdentifier.setUser(newUser);
        nationalUniqueIdentifierService.createNationalUniqueIdentifier(newNationalUniqueIdentifier);
        return userService.createUser(newUser);
    }
    public String   logInUser(String userEmailId,String userMobileNo,String password) {
        Optional<User> user = userService.findUserByEmailIdOrMobileNoAndPassword(userEmailId, userMobileNo, password);
        if (user.isPresent()) {
            return "User has been login successfully.....!";
        } else {
            return  "User not found......!";
        }
    }
    public String validateOtp(String Otp) {
        Optional<User> user = userService.findByUserOtp(Otp);
        User usr=user.get();
        if (Duration.between(usr.getOtpGeneratedTime(), LocalTime.now()).toMinutes() ==1){
            return  "Otp has been validated....!";
        }
        else if (Duration.between(usr.getOtpGeneratedTime(), LocalTime.now()).toMinutes() > 1) {
            usr.setUserOtp(CommonUtil.generateOtp());
            usr.setOtpGeneratedTime(LocalTime.now());
            userService.createUser(usr);
            return "New otp has been send on your registered email bcs existing one expired....!";
        }
        return "Please enter valid otp....!";
    }
    public void forgotPassword(String userEmailId,String userMobileNo) {
        Optional<User> user = userService.findUserByEmailIdOrMobileNo(userEmailId, userMobileNo);
        User usr=user.get();
        usr.setUserOtp(CommonUtil.generateOtp());
        usr.setOtpGeneratedTime(LocalTime.now());
        userService.createUser(user.get());

    }
    public String resetPassword(String userEmailId,String userMobileNo,String password ){
        Optional<User> user = userService.findUserByEmailIdOrMobileNo(userEmailId, userMobileNo);
        user.get().setPassword(password);
        userService.createUser(user.get());
        return "Password has been successfully updated...!";
    }
    public UserResponse getresponse(Optional<User> user){
        return UserResponse.builder()
                .id(user.get().getId())
                .firstName(user.get().getFirstName())
                .middleName(user.get().getMiddleName())
                .lastName(user.get().getLastName())
                .emailId(user.get().getEmailId())
                .mobileNo(user.get().getMobileNo())
                .consumerId(user.get().getConsumerId())
                .roleType(user.get().getRoleType())
                .genderType(user.get().getGenderType())
                .countryEnum(user.get().getCountryEnum())
                .build();
    }
    public List<UserListResponse> getAllUsers(List<User> users){
        List<UserListResponse> responses= new ArrayList<>();
        users.forEach(user ->{
            responses.add(UserListResponse.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .middleName(user.getMiddleName())
                    .lastName(user.getLastName())
                    .emailId(user.getEmailId())
                    .mobileNo(user.getMobileNo())
                    .consumerId(user.getConsumerId())
                    .roleType(user.getRoleType())
                    .genderType(user.getGenderType())
                    .countryEnum(user.getCountryEnum())
                    .build());
        } );
        return responses;
    }


}