package com.logicminds.usedcar;

public class Toyota extends Car {

    private String accidentSeverity;

    public Toyota(String model, int year, int mileage, String accidentSeverity) {
        super("Toyota", model, year, mileage);
        this.accidentSeverity = accidentSeverity.toLowerCase();
    }

    @Override
    public double getBasePrice() {
        return 30000;
    }

    public double getEstimatedPrice() {
        double price = getBasePrice();

        price -= (mileage / 10000) * 500;

        switch(accidentSeverity) {
            case "light": price -= price * 0.05; break;
            case "medium": price -= price * 0.15; break;
            case "heavy": price -= price * 0.30; break;
        }

        return Math.max(price, 0);
    }
}
