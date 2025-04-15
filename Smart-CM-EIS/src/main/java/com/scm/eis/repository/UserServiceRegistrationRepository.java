package com.scm.eis.repository;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.UserServiceRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserServiceRegistrationRepository extends JpaRepository<UserServiceRegistration, Long> {

    @Query("SELECT u FROM UserServiceRegistration u WHERE u.ticketNumber = :ticketNumber AND u.active = :active AND u.solutionStatus IS NOT NULL AND u.solutionStatus IN :solutionStatuses")
    Optional<UserServiceRegistration> findByTicketNumberAndActiveAndInSolutionStatusInList(
            @Param("ticketNumber") String ticketNumber,
            @Param("active") boolean active,
            @Param("solutionStatuses") List<SolutionStatus> solutionStatuses);

    public UserServiceRegistration findByTicketNumberAndActiveTrue(String ticketNumber);

}
