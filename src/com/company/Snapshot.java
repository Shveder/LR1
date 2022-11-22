package com.company;
public class Snapshot {
    private User user;
    private String login;
    private String password;
    private int role;

    public Snapshot(User user) {
        this.user = user;
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public void restore(){
        user.setRole(role);
        user.setLogin(login);
        user.setPassword(password);
    }
}