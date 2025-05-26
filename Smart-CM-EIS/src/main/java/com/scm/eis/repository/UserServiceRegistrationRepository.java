package com.scm.eis.repository;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.UserServiceRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserServiceRegistrationRepository extends JpaRepository<UserServiceRegistration, Long> {

    @Query("SELECT usr FROM UserServiceRegistration usr Right JOIN User u ON usr.user.id = u.id WHERE  (u.consumerId =:consumerId AND usr.active =true AND usr.solutionStatus IN (com.scm.eis.constant.SolutionStatus.CREATED, com.scm.eis.constant.SolutionStatus.ON_HOLD,com.scm.eis.constant.SolutionStatus.IN_PROGRESS,com.scm.eis.constant.SolutionStatus.PENDING)) ")
    Optional<UserServiceRegistration> findByConsumerIdAndActiveTrueAndSolutionStatus(String consumerId);


    @Query("SELECT usr FROM UserServiceRegistration usr Left JOIN User u ON usr.user.id = u.id WHERE  (u.consumerId =:consumerId AND usr.active =true AND usr.notificationRead=true)")
    Optional<UserServiceRegistration> findByActiveTrueAndNotificationReadTrueAndUserConsumerId(String consumerId);

    UserServiceRegistration findByTicketNumberAndActiveTrue(String ticketNumber);

    @Query("SELECT us FROM UserServiceRegistration us WHERE us.notificationRead = true")
    List<UserServiceRegistration> findUnreadNotifications();

}
