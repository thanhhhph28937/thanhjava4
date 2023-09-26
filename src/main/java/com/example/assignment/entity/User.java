package com.example.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

/*
CREATE TABLE Users(
    id varchar(100) PRIMARY KEY,
    password varchar(100) COLLATE Latin1_General_100_BIN2_UTF8 NOT NULL,
    fullname varchar(100) COLLATE Latin1_General_100_BIN2_UTF8 NOT NULL,
    email varchar(100) COLLATE Latin1_General_100_BIN2_UTF8 NOT NULL,
    photo varchar(500) COLLATE Latin1_General_100_BIN2_UTF8,
    activated tinyint,
    admin tinyint
);
 */
@Entity
@Table(name="users")
public class User {
    @Id
    String id;

    String password;
    String fullname;
    String email;
    String photo;
    Boolean activated;
    Boolean admin;

    @OneToMany(mappedBy = "user")
    List<Favorite> favorites;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }
}
