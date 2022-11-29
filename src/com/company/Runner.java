package com.company;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Runner implements Runnable{

    @Override
    public void run() {
        carShowroom.setList( carShowroom.getCarList().stream().sorted(Comparator.comparingInt(Car::getCost).reversed()).collect(Collectors.toList()));
    }
}
