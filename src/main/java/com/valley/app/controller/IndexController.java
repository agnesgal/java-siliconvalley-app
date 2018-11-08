package com.valley.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class IndexController {

    @GetMapping("/")
    public String welcomeView() throws IOException {
        return "index";
    }
}
