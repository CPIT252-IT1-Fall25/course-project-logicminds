package com.logicminds.usedcar;

public class CarFactory {

    public static Car createCar(String brand, String model, int year, int mileage, String accidentSeverity) {
        return new Car(brand, model, year, mileage, accidentSeverity);
    }
}
