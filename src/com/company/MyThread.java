package com.company;

import java.util.Comparator;
import java.util.stream.Collectors;

public class MyThread extends Thread {
    public void run(){
        carShowroom.setList( carShowroom.getCarList().stream().sorted(Comparator.comparingInt(Car::getCost)).collect(Collectors.toList()));
    System.out.println("Hello suka");
    }

}
