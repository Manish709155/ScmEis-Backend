package com.scm.eis.serviceImpl;

import com.scm.eis.entity.Company;
import com.scm.eis.entity.User;
import com.scm.eis.repository.CompanyRepository;
import com.scm.eis.response.CompanyListResponse;
import com.scm.eis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long companyId) {
        return companyRepository.findById(companyId).get();

    }
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

}
