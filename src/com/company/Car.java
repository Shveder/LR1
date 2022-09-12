package com.company;

public class Car
{
    private static String carModel;
    private static int quaranteeMonth;
    private static String additionalFeatures;
    private static int cost;

    public Car()
    {
    }
    public Car(String carModel, int quaranteeMonth, String additionalFeatures, int cost)
    {
        this.carModel = carModel;
        this.quaranteeMonth = quaranteeMonth;
        this.additionalFeatures = additionalFeatures;
        this.cost = cost;
    }

    public static String getCarModel()
    {
        return carModel;
    }
    public static int getGuaranteeMonth()
    {
        return quaranteeMonth;
    }
    public static String getAdditionalFeatures() {
        return additionalFeatures;
    }
    public static int getCost()
    {
        return cost;
    }
    public static void setCarModel()
    {
        Car.carModel = carModel;
    }
    public static void setQuaranteeMonth()
    {
        Car.quaranteeMonth = quaranteeMonth;
    }
    public static void setAdditionalFeatures(String additionalFeatures) {
        Car.additionalFeatures = additionalFeatures;
    }
    public static void setCost(int cost)
    {
       Car.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{}";
    }
}
