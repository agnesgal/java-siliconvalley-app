package com.valley.app.controller;

import com.auth0.SessionUtils;
import com.valley.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings("unused")
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    protected String home(final Map<String, Object> mapModel, final HttpServletRequest req, Model model) {

        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");

        if (accessToken != null) {
            mapModel.put("userId", accessToken);
        } else if (idToken != null) {
            mapModel.put("userId", idToken);
        }

        if(userService.getOurUser().getName() != null) {
            String name = userService.getOurUser().getName();
            String picture = userService.getOurUser().getPicture();

            model.addAttribute("name", name);
            model.addAttribute("picture", picture);
        }
        else model.addAttribute("name", "here!");

        return "index";
    }
}
