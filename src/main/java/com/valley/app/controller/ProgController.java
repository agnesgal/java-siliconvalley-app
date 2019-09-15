package com.valley.app.controller;

import com.valley.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgController {
    @Autowired
    UserService userService;
    @GetMapping("/prog")
    public String progView(Model model) {
        String name = userService.getOurUser().getName();
        String picture = userService.getOurUser().getPicture();

        model.addAttribute("name", name);
        model.addAttribute("picture", picture);

        return "prog";
    }}
