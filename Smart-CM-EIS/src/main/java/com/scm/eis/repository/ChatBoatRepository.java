package com.scm.eis.repository;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.ChatBoat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBoatRepository extends JpaRepository<ChatBoat,Long> {

    public ChatBoat findByUserIdAndActiveTrue(Long userId);
}
