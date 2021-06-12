package com.nuwe.entity;

public class GitlabUser {

    private String id;
    private String username;
    private String url;
    private int repositories;
    private String repositoriesURL;

    public GitlabUser() {
    }

    public GitlabUser(String id, String username, String url, int repositories, String repositoriesURL) {
        this.id = id;
        this.username = username;
        this.url = url;
        this.repositories = repositories;
        this.repositoriesURL = repositoriesURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRepositories() {
        return repositories;
    }

    public void setRepositories(int repositories) {
        this.repositories = repositories;
    }

    public String getRepositoriesURL() {
        return repositoriesURL;
    }

    public void setRepositoriesURL(String repositoriesURL) {
        this.repositoriesURL = repositoriesURL;
    }
}
