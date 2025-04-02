package com.scm.eis.repository;

import com.scm.eis.entity.NationalUniqueIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NationalUniqueIdentifierRepository extends JpaRepository<NationalUniqueIdentifier, Long> {
    Optional<NationalUniqueIdentifier> findByPanNumberOrAdharNumber(String panNumber, String adharNumber);
}
