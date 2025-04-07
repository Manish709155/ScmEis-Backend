package com.scm.eis.service;

import com.scm.eis.entity.NationalUniqueIdentifier;

import java.util.Optional;

public interface NationalUniqueIdentifierService {
    Optional<NationalUniqueIdentifier> findByPanNumberOrAdharNumber(String panNumber, String adharNumber);

    NationalUniqueIdentifier createNationalUniqueIdentifier(NationalUniqueIdentifier nationalUniqueIdentifier);

}
