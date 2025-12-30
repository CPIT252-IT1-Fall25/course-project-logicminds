package com.logicminds.usedcar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CarController {

    private final EstimatorService estimatorService;

    public CarController(EstimatorService estimatorService) {
        this.estimatorService = estimatorService;
    }

    @GetMapping("/car-form")
    public String carForm() {
        return "car-form";
    }

    @PostMapping("/estimate")
    public String estimatePrice(@RequestParam String brand,
                                @RequestParam String modelName,
                                @RequestParam int year,
                                @RequestParam int mileage,
                                @RequestParam String accidentSeverity,
                                Model uiModel) {

        Car car = CarFactory.createCar(brand, modelName, year, mileage, accidentSeverity);
        Brand brandEnum = Brand.fromString(brand);
        Map<String, Double> range = estimatorService.estimateRange(car, brandEnum);

        uiModel.addAttribute("car", car);
        uiModel.addAttribute("min", range.get("min"));
        uiModel.addAttribute("max", range.get("max"));
        uiModel.addAttribute("final", range.get("final"));

        return "result";
    }
}
