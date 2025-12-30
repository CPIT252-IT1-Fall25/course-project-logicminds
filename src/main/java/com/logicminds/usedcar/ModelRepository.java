package com.logicminds.usedcar;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ModelRepository {
    private final Map<String, List<String>> models = new HashMap<>();

    public ModelRepository() {
        models.put("Toyota", Arrays.asList("Camry", "Corolla", "RAV4", "Yaris", "Prius"));
        models.put("Hyundai", Arrays.asList("Elantra", "Accent", "Sonata", "Tucson", "Santa Fe"));
        models.put("Honda", Arrays.asList("Civic", "Accord", "CR-V", "City", "Fit"));
        models.put("Nissan", Arrays.asList("Sentra", "Altima", "Kicks", "Rogue"));
        models.put("Kia", Arrays.asList("Rio", "Cerato", "Sportage", "Sorento"));
        models.put("BMW", Arrays.asList("3 Series", "5 Series", "X3", "X5"));
        models.put("Mercedes", Arrays.asList("C-Class", "E-Class", "GLA", "GLC"));
        models.put("Ford", Arrays.asList("Focus", "Mustang", "Escape", "Explorer"));
        models.put("Other", Collections.emptyList());
    }

    public List<String> getModelsForBrand(String brand) {
        return models.getOrDefault(brand, Collections.emptyList());
    }

    public List<String> getBrands() {
        List<String> list = new ArrayList<>(models.keySet());
        list.sort(String::compareTo);
        return list;
    }
}
