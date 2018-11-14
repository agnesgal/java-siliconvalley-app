package com.valley.app.controller;

import com.valley.app.model.Company;
import com.valley.app.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CompanyRepository coRepo;

    @GetMapping("/")
    public String authorization() throws IOException {
        return "auth";
    }

    @GetMapping("/index")
    public String authorisa() throws IOException {
        return "index";
    }

    @GetMapping("/company")
    public String companiesView(Model model) throws IOException {
        List<Company> companyList = coRepo.findAll();
        model.addAttribute("companies", companyList);
        return "company";
    }

    @GetMapping("/design")
    public String design() throws IOException {
        return "design";
    }
}
