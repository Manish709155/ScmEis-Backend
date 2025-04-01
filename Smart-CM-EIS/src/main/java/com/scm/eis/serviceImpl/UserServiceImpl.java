package com.scm.eis.serviceImpl;

import com.scm.eis.entity.User;
import com.scm.eis.repository.UserRepository;
import com.scm.eis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmailIdOrMobileNo(String userEmailId, String userMobileNo) {
        return userRepository.findUserByEmailIdOrMobileNo(userEmailId,userMobileNo);
    }

    @Override
    public Optional<User> findUserByEmailIdOrMobileNoAndPassword(String userEmailId, String userMobileNo, String password) {
       return userRepository.findUserByEmailIdOrMobileNoAndPassword(userEmailId,userMobileNo,password);
    }

    @Override
    public Optional<User> findByUserOtp(String otp) {
        return userRepository.findByUserOtp(otp);
    }
}
