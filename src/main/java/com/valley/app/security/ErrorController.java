package com.valley.app.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@SuppressWarnings("unused")
@Controller
public class ErrorController {

    private final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    private static final String PATH = "/error";

//    @RequestMapping("/error")
//    protected String error(final RedirectAttributes redirectAttributes) throws IOException {
//        logger.error("Handling error");
//        redirectAttributes.addFlashAttribute("error", true);
//        return "redirect:/";
//    }

    public String getErrorPath() {
        return PATH;
    }

}