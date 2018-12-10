package com.valley.app.repository;

import com.valley.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsrId(String usrId);

}
