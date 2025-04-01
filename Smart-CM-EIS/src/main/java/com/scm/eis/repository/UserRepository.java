package com.scm.eis.repository;

import com.scm.eis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmailIdOrMobileNo(String userEmailId, String userMobileNo);

    Optional<User> findUserByEmailIdOrMobileNoAndPassword(String userEmailId, String userMobileNo, String password);

    Optional<User> findByUserOtp(String otp);
}
