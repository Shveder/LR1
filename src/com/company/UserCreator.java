package com.company;

public class UserCreator {
    Builder builder = new Builder();

    public User createUser(String login, String password, int role) {
        builder.create();
        builder.setLogin(login);
        builder.setPassword(password);
        builder.setRole(role);
        return builder.getUser();
    }
}