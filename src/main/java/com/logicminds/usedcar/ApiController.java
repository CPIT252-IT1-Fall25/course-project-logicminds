package com.logicminds.usedcar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final ModelRepository modelRepository;

    public ApiController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @GetMapping("/api/brands")
    public List<String> brands() {
        return modelRepository.getBrands();
    }

    @GetMapping("/api/models/{brand}")
    public List<String> models(@PathVariable String brand) {
        return modelRepository.getModelsForBrand(brand);
    }
}
