package com.features.task.mapper;

import com.features.task.dto.FeatureDto;
import com.features.task.entities.Feature;

public interface FeatureMapper {
    FeatureDto mapToDto(Feature entity);

    Feature mapToEntity(FeatureDto dto);
}
