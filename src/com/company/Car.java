package com.company;

public class Car
{
    private static String carModel;
    private static int quaranteeMonth;
    private static String additionalFeatures;
    private static int cost;

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
        return super.toString();
    }
}
