package com.logicminds.usedcar;

public abstract class Car {
    protected String make;
    protected String model;
    protected int year;
    protected int mileage;

    public Car(String make, String model, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public abstract double getBasePrice();

    @Override
    public String toString() {
        return make + " " + model + " (" + year + "), Mileage: " + mileage;
    }
}