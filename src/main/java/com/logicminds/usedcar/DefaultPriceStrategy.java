package com.logicminds.usedcar;

import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class DefaultPriceStrategy implements PriceStrategy {

    @Override
    public double estimate(Car car, Brand brand) {
        double price = brand.getBasePrice();

        int currentYear = Year.now().getValue();
        int age = Math.max(0, currentYear - car.getYear());
        double depreciation = Math.min(age * 0.05, 0.8);
        price = price * (1 - depreciation);

        int mileage = car.getMileage();
        if (mileage > 200_000) {
            price *= 0.75;
        } else if (mileage > 150_000) {
            price *= 0.82;
        } else if (mileage > 100_000) {
            price *= 0.88;
        } else if (mileage > 60_000) {
            price *= 0.93;
        }

        String accident = car.getAccidentSeverity();
        switch (accident) {
            case "light":
                price *= 0.95;
                break;
            case "medium":
                price *= 0.65;
                break;
            case "heavy":
                price *= 0.40;
                break;
            default:
                break;
        }

        price = price * brand.getMultiplier();

        return Math.max(price, 0);
    }
}
