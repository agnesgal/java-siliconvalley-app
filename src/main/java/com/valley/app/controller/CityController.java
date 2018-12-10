package com.valley.app.controller;

import com.valley.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {
    @Autowired
    UserService userService;

    @GetMapping("/city")
    public String companiesView(Model model) {
        String name = userService.getOurUser().getName();
        String picture = userService.getOurUser().getPicture();

        model.addAttribute("name", name);
        model.addAttribute("picture", picture);

        return "city";
    }
}
