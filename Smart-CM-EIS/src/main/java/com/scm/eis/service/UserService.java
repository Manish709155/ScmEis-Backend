package com.scm.eis.service;

import com.scm.eis.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long userId);

    User createUser(User user);

    Optional<User> findUserByEmailIdOrMobileNo(String userEmailId,String userMobileNo);

    Optional<User> findUserByEmailIdOrMobileNoAndPassword(String userEmailId,String userMobileNo,String password);

    Optional<User> findByUserOtp(String otp);

    List<User> getAllUsers();

}
