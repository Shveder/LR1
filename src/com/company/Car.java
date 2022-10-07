package com.company;

public class Car
{
    private  String carModel;
    private  int guaranteeMonth;
    private  String additionalFeatures;
    private  int cost;

    public Car()
    {
    }
    public Car(String carModel, int guaranteeMonth, String additionalFeatures, int cost)
    {
        this.carModel = carModel;
        this.guaranteeMonth = guaranteeMonth;
        this.additionalFeatures = additionalFeatures;
        this.cost = cost;
    }

    public  String getCarModel()
    {
        return carModel;
    }
    public  int getGuaranteeMonth()
    {
        return guaranteeMonth;
    }
    public  String getAdditionalFeatures() {
        return additionalFeatures;
    }
    public  int getCost()
    {
        return cost;
    }
    public  void setCarModel(String carModel)
    {
        this.carModel = carModel;
    }
    public void setGuaranteeMonth(int guaranteeMonth) {
        this.guaranteeMonth = guaranteeMonth;
    }
    public void setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }
    public  void setCost(int cost)
    {
       this.cost = cost;
    }

    public  String toString() {
        return "Car{" +
                " Car model = " + carModel +
                "/ guarantee month = " + guaranteeMonth +
                "/ additional features = " + additionalFeatures +
                "/ cost = " + cost + "$" +
                "}";
    }
}