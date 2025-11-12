package com.logicminds.usedcar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    @GetMapping("/car-form")
    public String carForm() {
        return "car-form";
    }

    @PostMapping("/estimate")
    public String estimatePrice(@RequestParam String make,
                                @RequestParam String model,
                                @RequestParam int year,
                                @RequestParam int mileage,
                                @RequestParam String accidentSeverity,
                                Model uiModel) {

        Car car;
        switch(make.toLowerCase()) {
            case "toyota":
                car = new Toyota(model, year, mileage, accidentSeverity);
                break;
            case "hyundai":
                car = new Hyundai(model, year, mileage, accidentSeverity);
                break;
            default:
                uiModel.addAttribute("error", "Company not supported yet.");
                return "car-form";
        }

        double estimatedPrice;
        if (car instanceof Toyota t) {
            estimatedPrice = t.getEstimatedPrice();
        } else if (car instanceof Hyundai h) {
            estimatedPrice = h.getEstimatedPrice();
        } else {
            estimatedPrice = 0;
        }

        uiModel.addAttribute("car", car);
        uiModel.addAttribute("estimatedPrice", estimatedPrice);

        return "result";
    }
}