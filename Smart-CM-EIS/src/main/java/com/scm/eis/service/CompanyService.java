package com.scm.eis.service;

import com.scm.eis.entity.Company;

public interface CompanyService {

    public Company createCompany(Company company);

    public Company findCompanyById(Long companyId);
}
