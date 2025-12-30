package com.logicminds.usedcar;

public enum Brand {
    TOYOTA("Toyota", 1.15, 80000),
    HONDA("Honda", 1.10, 75000),
    NISSAN("Nissan", 1.00, 72000),
    HYUNDAI("Hyundai", 0.90, 60000),
    KIA("Kia", 0.88, 59000),
    BMW("BMW", 1.20, 150000),
    MERCEDES("Mercedes", 1.25, 170000),
    FORD("Ford", 1.12, 100000),
    OTHER("Other", 1.00, 50000);

    private final String displayName;
    private final double multiplier;
    private final int basePrice;

    Brand(String displayName, double multiplier, int basePrice) {
        this.displayName = displayName;
        this.multiplier = multiplier;
        this.basePrice = basePrice;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public static Brand fromString(String s) {
        if (s == null) {
            return OTHER;
        }
        for (Brand b : values()) {
            if (b.displayName.equalsIgnoreCase(s) || b.name().equalsIgnoreCase(s)) {
                return b;
            }
        }
        return OTHER;
    }
}
