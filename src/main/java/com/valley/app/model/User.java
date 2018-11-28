package com.valley.app.model;

import javax.persistence.*;

@Entity
@Table(name="usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String usrId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String given_name;

    @Column(nullable = false)
    private String family_name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    private String updated_at;

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public User() {
    }

    public User(String usrId, String email, String given_name, String family_name, String nickname, String name, String picture, String updated_at) {
        this.usrId = usrId;
        this.email = email;
        this.given_name = given_name;
        this.family_name = family_name;
        this.nickname = nickname;
        this.name = name;
        this.picture = picture;
        this.updated_at = updated_at;
    }
}
