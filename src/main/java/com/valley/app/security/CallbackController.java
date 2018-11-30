package com.valley.app.security;

import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import com.auth0.client.auth.AuthAPI;
import com.auth0.json.auth.UserInfo;
import com.auth0.net.Request;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.valley.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@SuppressWarnings("unused")
@Controller
public class CallbackController {

    @Autowired
    private AuthController controller;
    private final String redirectOnFail;
    private final String redirectOnSuccess;
    private final AppConfig config;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    UserService uService;

    public CallbackController(AppConfig config) {
        this.redirectOnFail = "/";
        this.redirectOnSuccess = "/home";
        this.config = config;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    protected void getCallback(final HttpServletRequest req, final HttpServletResponse res) throws IOException, UnirestException {
        handle(req, res);
    }

    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    protected void postCallback(final HttpServletRequest req, final HttpServletResponse res) throws IOException, UnirestException {
        handle(req, res);
    }

    private void handle(HttpServletRequest req, HttpServletResponse res) throws IOException, UnirestException {
        try {
            Tokens tokens = controller.handle(req);
            SessionUtils.set(req, "accessToken", tokens.getAccessToken());
            SessionUtils.set(req, "idToken", tokens.getIdToken());

            AuthAPI auth = new AuthAPI(config.getDomain(), config.getClientId(), config.getClientSecret());
            Request<UserInfo> request = auth.userInfo(tokens.getAccessToken());
            RestTemplate template = restTemplateBuilder.build();
            UserInfo info = request.execute();
            String clientId = (String)info.getValues().get("sub");
            String url = "https://svalley.auth0.com/api/v2/users/" + clientId;

            Object response = Unirest.post("https://svalley.auth0.com/oauth/token")
                    .header("Content-Type", "application/json")
                    .header("cache-control", "no-cache")
                    .header("Postman-Token", "1dad1302-a912-458c-bbc4-6e661751dce7")
                    .body("{\"client_id\": \"hyUHuT6pKUEglXtjiiBkG6W5RApNbUNA\",\n\"client_secret\":\"kCKkP762h6zXZPOpawyQnd0AEFca6btwdA5GjzZOE66XXJQu2ueE_gOWucxGtVwx\",\n\"audience\":\"https://svalley.auth0.com/api/v2/\",\n\"grant_type\":\"client_credentials\"}")
                    .asJson().getBody().getObject().getString("access_token");

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + response.toString());
            HttpEntity entity = new HttpEntity(headers);
            ResponseEntity<HashMap> userData = template.exchange(url, HttpMethod.GET, entity, HashMap.class);
            uService.createUser(userData);

            res.sendRedirect(redirectOnSuccess);
        }

        catch (IdentityVerificationException e) {
            e.printStackTrace();
            res.sendRedirect(redirectOnFail);
        }
    }

}
