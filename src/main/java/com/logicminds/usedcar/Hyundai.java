package com.logicminds.usedcar;

public class Hyundai extends Car {

    private String accidentSeverity;

    public Hyundai(String model, int year, int mileage, String accidentSeverity) {
        super("Hyundai", model, year, mileage);
        this.accidentSeverity = accidentSeverity.toLowerCase();
    }

    @Override
    public double getBasePrice() {
        return 25000;
    }

    public double getEstimatedPrice() {
        double price = getBasePrice();

        price -= (mileage / 10000) * 700;

        switch(accidentSeverity) {
            case "light": price -= price * 0.07; break;
            case "medium": price -= price * 0.17; break;
            case "heavy": price -= price * 0.35; break;
        }

        return Math.max(price, 0);
    }
}
