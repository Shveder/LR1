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
    public List<Car>getCarList()
    {
        return carList;
    }
    public void setList(List<Car>carList)
    {
        this.carList = carList;
    }
}