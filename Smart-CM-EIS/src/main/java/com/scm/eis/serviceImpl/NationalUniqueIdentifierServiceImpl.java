package com.scm.eis.serviceImpl;

import com.scm.eis.entity.NationalUniqueIdentifier;
import com.scm.eis.repository.NationalUniqueIdentifierRepository;
import com.scm.eis.service.NationalUniqueIdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationalUniqueIdentifierServiceImpl implements NationalUniqueIdentifierService {

    @Autowired
    NationalUniqueIdentifierRepository nationalUniqueIdentifierRepository;



    @Override
    public Optional<NationalUniqueIdentifier> findByPanNumberOrAdharNumber(String panNumber, String adharNumber) {
        return nationalUniqueIdentifierRepository.findByPanNumberOrAdharNumber(panNumber, adharNumber);
    }
}
