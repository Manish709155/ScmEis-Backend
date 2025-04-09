package com.scm.eis.service;

import com.scm.eis.entity.Company;

import java.util.List;

public interface CompanyService {

    public Company createCompany(Company company);

    public Company findCompanyById(Long companyId);

    public List<Company> getAllCompanies();

}
