package com.scm.eis.repository;

import com.scm.eis.entity.ChatBoat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatBoat,Long> {
}
