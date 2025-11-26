package com.marondal.springtest.jpa.service;

import com.marondal.springtest.jpa.domain.Company;
import com.marondal.springtest.jpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(
            String name
            , String business
            , String scale
            , int headcount) {

        Company company = Company.builder()
                .name(name)
                .business(business)
                .scale(scale)
                .headcount(headcount)
                .build();

        Company result = companyRepository.save(company);

        return result;
    }
}
