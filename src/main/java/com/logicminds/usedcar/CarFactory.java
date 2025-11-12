package com.logicminds.usedcar;

public class CarFactory {

    public static Car createCar(String make, String model, int year, int mileage) {
        switch(make.toLowerCase()) {
            case "toyota":
                return new Toyota(model, year, mileage, "none");
            case "hyundai":
                return new Hyundai(model, year, mileage, "none");
            default:
                throw new IllegalArgumentException("Company not supported yet.");
        }
    }
}
