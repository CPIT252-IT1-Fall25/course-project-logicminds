package com.logicminds.usedcar;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EstimatorService {

    private final PriceStrategy priceStrategy;

    public EstimatorService(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public Map<String, Double> estimateRange(Car car, Brand brand) {
        double central = priceStrategy.estimate(car, brand);

        double min = central * 0.90;
        double max = central * 1.10;

        Map<String, Double> result = new HashMap<>();
        result.put("min", (double) Math.round(min));
        result.put("max", (double) Math.round(max));
        result.put("final", (double) Math.round(central));

        return result;
    }
}
