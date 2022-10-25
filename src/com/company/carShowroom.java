package com.company;

import java.util.ArrayList;
import java.util.List;

public class carShowroom
{
    private static List<Car>carList;
    public carShowroom(List<Car>carList)
    {
        this.carList = carList;
    }
    public carShowroom()
    {
        carList = new ArrayList<>();
    }
    public static List<Car>getCarList()
    {
        return carList;
    }
    public static void setList(List<Car>carList1)
    {
        carList = carList1;
    }
    public static void addCar(Car car)
        {
            carList.add(car);
        }
}