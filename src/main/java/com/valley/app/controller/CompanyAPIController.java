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
import java.util.HashSet;
import java.util.List;

@RestController
public class CompanyAPIController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/company/search/{co_name}")
    public List<CompanyView> getCompanyLogoByName(@PathVariable("co_name") String searchedLetter) {
        String upperSearchedCo = searchedLetter.substring(0, 1).toUpperCase() + searchedLetter.substring(1).toLowerCase();

        List<Company> companyList = companyRepository.findByNameContaining(upperSearchedCo);
        List<Company> tempCoList = companyRepository.findByNameContaining(searchedLetter);
        companyList.addAll(tempCoList);

        HashSet<Object> seen = new HashSet<>();
        companyList.removeIf(e->!seen.add(e.getId()));

        List<CompanyView> toReturn = new ArrayList<>();
        for (Company co : companyList) {
            toReturn.add(CompanyView.create(co));
        }
        return toReturn;
    }
}
