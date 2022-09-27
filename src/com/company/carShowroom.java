package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Car>getCarList()
    {
        return carList;
    }
    public void setList(List<Car>carList)
    {
        this.carList = carList;
    }
    public static void addCar(Car car)
        {
            carList.add(car);
        }

}
