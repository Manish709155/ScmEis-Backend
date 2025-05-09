package com.scm.eis.repository;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.UserServiceRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatBoatRepository extends JpaRepository<ChatBoat,Long> {

    public ChatBoat findByUserIdAndActiveTrue(Long userId);

    @Query("SELECT ch FROM ChatBoat ch Right JOIN User u ON ch.user.id = u.id WHERE  (u.consumerId =:consumerId AND ch.active =true AND ch.solutionStatus IN (com.scm.eis.constant.SolutionStatus.CREATED, com.scm.eis.constant.SolutionStatus.ON_HOLD,com.scm.eis.constant.SolutionStatus.IN_PROGRESS,com.scm.eis.constant.SolutionStatus.PENDING)) ")
    Optional<ChatBoat> findByConsumerIdAndActiveTrueAndSolutionStatus(String consumerId);
}
