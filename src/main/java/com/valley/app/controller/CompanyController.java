package com.valley.app.controller;

import com.valley.app.model.Company;
import com.valley.app.repository.CompanyRepository;
import com.valley.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.exceptions.TemplateProcessingException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UserService userService;

    @Autowired
    CompanyAPIController companyAPIController;

    @GetMapping("/company")
    public String companiesView(Model model) {
        List<Company> companyList = companyRepository.findAll();
        List<Company> siliconCompList = new ArrayList<>();
        List<Company> wWideCompList = new ArrayList<>();

        for (Company comp : companyList) {
            if(comp.isSilicon()) siliconCompList.add(comp);
            else wWideCompList.add(comp);
        }

        model.addAttribute("siliconComps", siliconCompList);
        model.addAttribute("wWideComps", wWideCompList);

        String name = userService.getOurUser().getName();
        String picture = userService.getOurUser().getPicture();

        model.addAttribute("name", name);
        model.addAttribute("picture", picture);

        return "companies";
    }

    @GetMapping("/company/{co_id}")
    public String oneCompanyView(@PathVariable ("co_id") Long company_id, Model model) {
        try {
            String name = userService.getOurUser().getName();
            String picture = userService.getOurUser().getPicture();

            model.addAttribute("name", name);
            model.addAttribute("picture", picture   );

            Company company = companyRepository.getOne(company_id);
            model.addAttribute("company", company);

            return "company";
        }
        catch (TemplateProcessingException|NumberFormatException|EntityNotFoundException ex) {
            System.out.println("Expection appearance: " + ex);
            return "companies";
        }

    }

}
