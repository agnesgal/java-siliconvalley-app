package com.valley.app.service;

import com.valley.app.model.User;
import com.valley.app.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService  {

    @Autowired
    UserRepository uRepo;
    private User ourUser;

    public void createUser(ResponseEntity<HashMap> userData) {
        String usrStringId = userData.getBody().get("user_id").toString().substring(14, 34).trim();
        String email = (String)userData.getBody().get("email");
        String given_name = (String)userData.getBody().get("given_name");
        String family_name = (String)userData.getBody().get("family_name");
        String nickname = (String)userData.getBody().get("nickname");
        String name = (String)userData.getBody().get("name");
        String picture = (String)userData.getBody().get("picture");
        String updated_at = (String)userData.getBody().get("updated_at");
        ourUser = new User(usrStringId, email, given_name, family_name, nickname, name, picture, updated_at);

        if(uRepo.findByUsrId(usrStringId) == null) {
            uRepo.save(ourUser);
        }
    }

    public User getOurUser() {
        return ourUser;
    }
}
