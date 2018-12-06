package com.valley.app.controller;

import com.auth0.SessionUtils;
import com.valley.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class CityController {
    @Autowired
    UserService uService;

    @GetMapping("/city")
    public String companiesView(Model model, final HttpServletRequest req) throws IOException {
        if (SessionUtils.get(req, "accessToken") == null) { // not logged in
            return "redirect:/";
        }
//        String name = uService.getOurUser().getName();
//        String picture = uService.getOurUser().getPicture();
//
//        model.addAttribute("name", name);
//        model.addAttribute("picture", picture);

        return "city";
    }
}
