package com.logicminds.usedcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsedCarEstimatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsedCarEstimatorApplication.class, args);

        Car myCar = CarFactory.createCar("Toyota", "Camry", 2020, 30000);

        if (myCar instanceof Toyota toyotaCar) {
            System.out.println("The car has been created :");
            System.out.println(myCar.toString());
            System.out.println("Approximate price :" + toyotaCar.getEstimatedPrice());
        }
    }
}