package com.nuwe.entity;

public class GithubUser {

    private String id;
    private String login;
    private String url;
    private int public_repos;
    private String repos_url;

    public GithubUser() {
    }

    public GithubUser(String id, String login, String url, int public_repos, String repos_url) {
        this.id = id;
        this.login = login;
        this.url = url;
        this.public_repos = public_repos;
        this.repos_url = repos_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }
}
