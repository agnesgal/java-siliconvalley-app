package com.valley.app.controller;

import com.valley.app.model.Company;
import com.valley.app.repository.CompanyRepository;
import com.valley.app.viewmodel.CompanyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyAPIController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/company/search/{co_name}")
    public List<CompanyView> getCompanyLogoByName(@PathVariable("co_name") String company_name) {
        List<Company> companyList = new ArrayList<>();

        if (company_name.length() >= 1) {
            String upperFirstName = company_name.substring(0, 1).toUpperCase() + company_name.substring(1).toLowerCase();
            companyList = companyRepository.findByNameContaining(upperFirstName);
            List<Company> tempCoList = companyRepository.findByNameContaining(company_name);
            companyList.addAll(tempCoList);
        }

        List<CompanyView> toReturn = new ArrayList<>();
        for (Company co : companyList) {
            toReturn.add(CompanyView.create(co));
        }
        return toReturn;
    }
}
