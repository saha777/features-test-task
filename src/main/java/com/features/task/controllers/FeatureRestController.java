package com.features.task.controllers;

import com.features.task.dto.FeatureDto;
import com.features.task.dto.FeaturesDto;
import com.features.task.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/features")
@RequiredArgsConstructor
public class FeatureRestController {

    private final FeatureService featureService;

    @GetMapping
    public ResponseEntity<FeaturesDto> features() {
        return ResponseEntity.ok(featureService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDto> getFeatureById(@PathVariable Integer id) {
        return ResponseEntity.ok(featureService.getById(id));
    }

    @PostMapping
    public ResponseEntity<FeatureDto> create(@RequestBody @Valid FeatureDto featureDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(featureService.create(featureDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeatureDto> deleteFeatureById(@PathVariable Integer id) {
        return ResponseEntity.ok(featureService.deleteById(id));
    }
}
