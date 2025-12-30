package com.logicminds.usedcar;

public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final int mileage;
    private final String accidentSeverity;

    public Car(String brand, String model, int year, int mileage, String accidentSeverity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.accidentSeverity = accidentSeverity == null ? "none" : accidentSeverity.toLowerCase();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public String getAccidentSeverity() {
        return accidentSeverity;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + "), Mileage: " + mileage + " km";
    }
}
