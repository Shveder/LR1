package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
    private String login;
    private String password;
    private int role;

    public Snapshot createSnapShot(User user){
        return new Snapshot(user);
    }

    public User() {}
    public User(String login, String password, int role)
    {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public static void findByLogin(UserList userList,Scanner scanner){
        System.out.println("Enter login: ");
        String login = scanner.next();
        for(var i: userList.getUserList()){
            if(i.getLogin() == login){
                System.out.println(i.toString());
            }
        }
    }

    public static void editUser(UserList userList, Scanner scanner){
        Command cmd = new Command();
        System.out.println("Enter the login of the user you want to edit: ");
        String login = scanner.next();
        boolean doesUserExist = false;
        for(var i: userList.getUserList()){
            if(i.getLogin().equals(login)){
                cmd.makeBackup(i);
                System.out.println(i.toString());
                System.out.println("Enter Login: ");
                login = scanner.next();
                System.out.println("Enter password: ");
                String password = scanner.next();
                System.out.println("Enter role:");
                int role = Main.input_number(scanner);
                i.setLogin(login);
                i.setPassword(password);
                i.setRole(role);
                doesUserExist = true;
                System.out.println("Do you want to edit user?\n 1- Yes\n other- No");
                int isEdit = Main.input_number( scanner);
                if(isEdit == 0){
                    cmd.undo();
                    System.out.println("Undo");
                }
            }
        }
        if(!doesUserExist){
            System.out.println("There is no such user");
        }
    }

    public static void deleteUser(UserList userlist, Scanner scanner){
        System.out.println("Enter the login of the user you want to delete: ");
        String login = scanner.next();
        int numOfUser = 0;
        for(var i: userlist.getUserList()){
            if(i.getLogin().equals(login)){
                break;
            }
            numOfUser++;
        }
        System.out.println("Do you want to delete user?\n-1- Yes\n-0- No");
        int isDelete = Main.input_number(scanner);
        if(isDelete == 1){
            try {
                userlist.delete(numOfUser);
            } catch(Exception ex) {
                System.out.println("There is no such user");
            }
        }
    }

    public static void BanUser(UserList userlist, Scanner scanner){
        System.out.println("Enter the login of the user you want to ban: ");
        String login = scanner.next();
        for(var i: userlist.getUserList()){
            if(i.getLogin().equals(login)){
                i.setRole(0);
                System.out.println(i.toString());
                break;
            }
        }
    }
}

