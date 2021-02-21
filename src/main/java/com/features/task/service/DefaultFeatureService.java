package com.features.task.service;

import com.features.task.dto.FeatureDto;
import com.features.task.dto.FeaturesDto;
import com.features.task.entities.Feature;
import com.features.task.exceptions.ExceptionMessages;
import com.features.task.mapper.FeatureMapper;
import com.features.task.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultFeatureService implements FeatureService {

    private final FeatureRepository featureRepository;
    private final FeatureMapper mapper;

    @Override
    public FeaturesDto getAll() {
        return FeaturesDto.builder()
                .features(
                        featureRepository.findAll()
                                .stream()
                                .map(mapper::mapToDto)
                                .collect(Collectors.toList())
                ).build();
    }

    @Override
    public FeatureDto getById(Integer id) {
        return featureRepository.findById(id)
                .map(mapper::mapToDto)
                .orElseThrow(createNotFoundResponseSupplier(id));
    }

    @Override
    @Transactional
    public FeatureDto create(FeatureDto featureDto) {
        Feature feature = mapper.mapToEntity(featureDto);
        return mapper.mapToDto(featureRepository.save(feature));
    }

    @Override
    @Transactional
    public FeatureDto deleteById(Integer id) {
        FeatureDto featureDto = featureRepository.findById(id)
                .map(mapper::mapToDto)
                .orElseThrow(createNotFoundResponseSupplier(id));
        featureRepository.deleteById(id);
        return featureDto;
    }

    private Supplier<ResponseStatusException> createNotFoundResponseSupplier(Integer id) {
        return () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                ExceptionMessages.of(ExceptionMessages.NOT_FOUND_MESSAGE, id)
        );
    }
}
