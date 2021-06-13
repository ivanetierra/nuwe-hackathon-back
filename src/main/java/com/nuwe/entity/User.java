package com.nuwe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private boolean format_valid;
    private String password;
    private int gitlabUserId;
    private int countryId;

    public User() {
    }

    public User(String id, String name, String username, String email, boolean format_valid, String password, int gitlabUserId, int countryId) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.format_valid = format_valid;
        this.password = password;
        this.gitlabUserId = gitlabUserId;
        this.countryId = countryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getFormat_valid() {
        return format_valid;
    }

    public void setFormat_valid(boolean format_valid) {
        this.format_valid = format_valid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGitlabUserId() {
        return gitlabUserId;
    }

    public void setGitlabUserId(int gitlabUserId) {
        this.gitlabUserId = gitlabUserId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
