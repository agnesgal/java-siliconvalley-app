package com.valley.app.controller;

import com.auth0.SessionUtils;
import com.valley.app.repository.UserRepository;
import com.valley.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@SuppressWarnings("unused")
@Controller
public class HomeController {

    @Autowired
    UserService uService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    protected String home(final Map<String, Object> mapModel, final HttpServletRequest req, Model model) {
        // not logged in
        if (SessionUtils.get(req, "accessToken") == null) {
            return "redirect:/";
        }

        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");

        if (accessToken != null) {
            mapModel.put("userId", accessToken);
        } else if (idToken != null) {
            mapModel.put("userId", idToken);
        }

        if(uService.getOurUser().getName() != null) {
            String name = uService.getOurUser().getName();
            model.addAttribute("name", name);
        }
        else model.addAttribute("name", "here!");

        return "index";
    }
}
