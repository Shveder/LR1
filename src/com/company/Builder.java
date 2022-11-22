package com.company;
public class Builder {
    private User user;

    public void create() {
        user = new User();
    }

    public void setLogin(String login) {
        this.user.setLogin(login);
    }

    public void setPassword(String password) {
        this.user.setPassword(password);
    }

    public void setRole(int role) {
        this.user.setRole(role);
    }

    public User getUser() {
        return this.user;
    }


}