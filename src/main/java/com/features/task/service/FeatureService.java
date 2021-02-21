package com.features.task.service;

import com.features.task.dto.FeatureDto;
import com.features.task.dto.FeaturesDto;

public interface FeatureService {
    FeaturesDto getAll();
    FeatureDto getById(Integer id);
    FeatureDto create(FeatureDto featureDto);
    FeatureDto deleteById(Integer id);
}
