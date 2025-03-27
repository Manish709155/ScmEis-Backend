package com.scm.eis.service;

import com.scm.eis.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long userId);

    User createUser(User user);

    Optional<User> findUserByEmailIdOrMobileNo(String userEmailId,String userMobileNo);
}
