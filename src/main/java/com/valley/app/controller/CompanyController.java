package com.valley.app.controller;

import com.auth0.SessionUtils;
import com.valley.app.model.Company;
import com.valley.app.repository.CompanyRepository;
import com.valley.app.repository.UserRepository;
import com.valley.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyRepository coRepo;

    @Autowired
    UserService uService;

    @GetMapping("/company")
    public String companiesView(Model model, final HttpServletRequest req) throws IOException {
        if (SessionUtils.get(req, "accessToken") == null) { // not logged in
            return "redirect:/";
        }
        List<Company> companyList = coRepo.findAll();
        List<Company> siliconCompList = new ArrayList<>();
        List<Company> wWideCompList = new ArrayList<>();

        for (Company comp : companyList) {
            if(comp.isSilicon()) siliconCompList.add(comp);
            else wWideCompList.add(comp);
        }

        model.addAttribute("siliconComps", siliconCompList);
        model.addAttribute("wWideComps", wWideCompList);

        String name = uService.getOurUser().getName();
        String picture = uService.getOurUser().getPicture();

        model.addAttribute("name", name);
        model.addAttribute("picture", picture);

        return "companies";
    }

    @GetMapping("/company/{co_id}")
    public String oneCompanyView(@PathVariable ("co_id") Long company_id, Model model, final HttpServletRequest req) throws IOException {
        if (SessionUtils.get(req, "accessToken") == null) { // not logged in
            return "redirect:/";
        }
        String name = uService.getOurUser().getName();
        String picture = uService.getOurUser().getPicture();

        model.addAttribute("name", name);
        model.addAttribute("picture", picture);

        Company company = coRepo.getOne(company_id);
        model.addAttribute("company", company);
        return "company";
    }
}
