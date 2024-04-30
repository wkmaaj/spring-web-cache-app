package org.pdbcorp.spring.controllers;

import org.pdbcorp.spring.services.CalculationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/calculate")
// @Slf4j
public class CalculationController {

    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping(path = "/area/circle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> areaOfCircle(@RequestParam int radius) {
        return ResponseEntity.ok(calculationService.areaOfCircle(radius));
    }

    @GetMapping(path = "/multiply", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> multiply(@RequestParam int x, @RequestParam int y) {
        return ResponseEntity.ok(calculationService.multiply(x, y));
    }

    @PostMapping(path = "/clear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String clear(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

}
