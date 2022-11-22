package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    public static void setUserList(List<User> userList) {
        UserList.userList = userList;
    }

    private static List<User> userList;

    public UserList() {
        userList = new ArrayList<>();
    }

    public UserList(List<User> userList) {
        this.userList = userList;
    }

    public void delete(int numOfUser) {
        userList.remove(numOfUser);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public int getAmount() {
        return userList.toArray().length;
    }

    public void writeDataToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(getUserList());
            oos.close();
            System.out.println("Completed");
        } catch (IOException e) {
            System.out.println("Can't write data into file");
        }
    }
    public void readDataFromFile(String fileName) throws ClassNotFoundException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            userList = ((ArrayList<User>)ois.readObject());
            ois.close();
        } catch (IOException e) {
            System.out.println("Can't open file");
        }
    }
}