package com.valley.app.security;

import com.auth0.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@Controller
public class LoginController {

    @Autowired
    private AuthController controller;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/")
    protected String login(final HttpServletRequest req) {

        if (SessionUtils.get(req, "accessToken") != null) {
            return "redirect:/portal/home";
        }

        logger.debug("Performing login");
        String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";
        String authorizeUrl = controller.buildAuthorizeUrl(req, redirectUri);
        return "redirect:" + authorizeUrl;
    }

}
