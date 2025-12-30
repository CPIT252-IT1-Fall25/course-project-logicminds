package com.logicminds.usedcar;

public interface PriceStrategy {
    double estimate(Car car, Brand brand);
}
