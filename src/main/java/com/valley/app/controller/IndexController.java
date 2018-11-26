package com.valley.app.controller;

import com.auth0.SessionUtils;
import com.valley.app.model.Company;
import com.valley.app.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CompanyRepository coRepo;

    @GetMapping("/company")
    public String companiesView(Model model, final HttpServletRequest req) throws IOException {

        if (SessionUtils.get(req, "accessToken") == null) { // not logged in
            return "redirect:/";
        }

        List<Company> companyList = coRepo.findAll();
        model.addAttribute("companies", companyList);
        return "company";
    }

    @GetMapping("/design")
    public String design() throws IOException {
        return "design";
    }
}
