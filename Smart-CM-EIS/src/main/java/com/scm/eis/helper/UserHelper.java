package com.scm.eis.helper;

import com.scm.eis.constant.Constants;
import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.constant.State;
import com.scm.eis.entity.Address;
import com.scm.eis.entity.Company;
import com.scm.eis.entity.NationalUniqueIdentifier;
import com.scm.eis.entity.User;
import com.scm.eis.exception.UserCreateException;
import com.scm.eis.repository.UserRepository;
import com.scm.eis.request.DisAbleUserReuest;
import com.scm.eis.request.UserRequest;
import com.scm.eis.request.UserUpdateRequest;
import com.scm.eis.response.UserListResponse;
import com.scm.eis.response.UserLoginResponse;
import com.scm.eis.response.UserResponse;
import com.scm.eis.service.AddressService;
import com.scm.eis.service.CompanyService;
import com.scm.eis.service.NationalUniqueIdentifierService;
import com.scm.eis.service.UserService;
import com.scm.eis.util.CommonUtil;
import com.scm.eis.util.EmailSenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Component
public class UserHelper {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService  companyService;

    @Autowired
    NationalUniqueIdentifierService nationalUniqueIdentifierService;

    @Autowired
    AddressService addressService;

    @Autowired
    EmailSenderUtil emailSenderUtil;

    @Autowired
    UserRepository userRepository;


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
        Address address = new Address();
        address.setHouseNumber(userRequest.getAddressRequest().getHouseNumber());
        address.setCity(userRequest.getAddressRequest().getCity());
        address.setState(State.BIHAR);
        address.setDistrict(userRequest.getAddressRequest().getDistrict());
        address.setPostOfficeName(userRequest.getAddressRequest().getPostOfficeName());
        address.setPinCode(userRequest.getAddressRequest().getPinCode());
        address.setCountry(CountryEnum.INDIA);
        address.setPoliceStation(userRequest.getAddressRequest().getPoliceStation());
        address.setStreetName(userRequest.getAddressRequest().getStreetName());
        address.setApartmentNumber(userRequest.getAddressRequest().getApartmentNumber());
        address.setLandmarkNBYL(userRequest.getAddressRequest().getLandmarkNBYL());
        address.setAddressType(userRequest.getAddressRequest().getAddressType());
        address.setUser(newUser);
        addressService.createAddress(address);

        return userService.createUser(newUser);
    }

    public UserLoginResponse logInUser(String userEmailId, String userMobileNo, String password) {
        Optional<User> user = userService.findUserByEmailIdOrMobileNoAndPassword(userEmailId, userMobileNo, password);

        if (user.isPresent()) {
            return UserLoginResponse.builder()
                    .loginUserId(user.get().getId())
                    .loginConsumerId(user.get().getConsumerId())
                    .loginResponse("User has been login successfully.....!")
                    .build();
        } else {
            throw new RuntimeException("User not found......!");
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
        Map<String,Object> model = new HashMap<>();
        model.put("otp",usr.getUserOtp());
        model.put("name",usr.getFirstName()+" "+usr.getMiddleName()+" "+usr.getLastName());
        new Thread() {
            public void run() {
                emailSenderUtil.sendEmail(usr.getEmailId(), model,
                        Constants.VALIDATE_OTP_EMAIL_TEMPLATE, Constants.VALIDATE_OTP_SUBJECT);
            }
        }.start();

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
      Address address=addressService.findByActiveTrueAndUserId(user.get().getId());
        NationalUniqueIdentifier nationalUniqueIdentifier=nationalUniqueIdentifierService.findByActiveTrueAndUserId(user.get().getId());
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
                .countryEnum(address.getCountry())
                .city(address.getCity())
                .state(address.getState())
                .houseNo(address.getHouseNumber())
                .pinCode(address.getPinCode())
                .district(address.getDistrict())
                .panNumber(nationalUniqueIdentifier.getPanNumber())
                .adharNumber(nationalUniqueIdentifier.getAdharNumber())
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

    public User updateUserContact(UserUpdateRequest request) {
        Optional<User> optionalUser = userRepository.findById(request.getId());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + request.getId());
        }

        User user = optionalUser.get();
        user.setEmailId(request.getEmailId());
        user.setMobileNo(request.getMobileNo());

        return userRepository.save(user);
    }


    public  void disableUser(String  consumerId){
      User user=  userService.findByActiveTrueAndConsumerId(consumerId);
      user.setActive(Boolean.FALSE);
      user.setDeleted(Boolean.TRUE);
      userService.createUser(user);

    }

}