package com.features.task.mapper;

import com.features.task.dto.FeatureDto;
import com.features.task.dto.ServicesDto;
import com.features.task.entities.Feature;
import org.springframework.stereotype.Component;

@Component
public class DefaultFeatureMapper implements FeatureMapper {
    @Override
    public FeatureDto mapToDto(Feature entity) {
        return FeatureDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .companyId(entity.getCompanyId())
                .nameRu(entity.getNameRu())
                .nameUa(entity.getNameUa())
                .nameEn(entity.getNameEn())
                .isOnline(entity.isOnline())
                .isVisible(entity.isVisible())
                .workHours(entity.getWorkHours())
                .servicesDto(
                        ServicesDto.builder()
                                .vip(entity.isVip())
                                .allHours(entity.isAllHours())
                                .pi(entity.isPi())
                                .entities(entity.isEntities())
                                .premium(entity.isPremium())
                                .englishSpeaking(entity.isEnglishSpeaking())
                        .build()
                )
                .build();
    }

    @Override
    public Feature mapToEntity(FeatureDto dto) {
        ServicesDto servicesDto = dto.getServicesDto();

        Feature feature = new Feature();
        feature.setType(dto.getType());
        feature.setCompanyId(dto.getCompanyId());
        feature.setNameRu(dto.getNameRu());
        feature.setNameUa(dto.getNameUa());
        feature.setNameEn(dto.getNameEn());
        feature.setWorkHours(dto.getWorkHours());
        feature.setOnline(dto.isOnline());
        feature.setVisible(dto.isVisible());

        feature.setEntities(servicesDto.isEntities());
        feature.setAllHours(servicesDto.isAllHours());
        feature.setPi(servicesDto.isPi());
        feature.setPremium(servicesDto.isPremium());
        feature.setEnglishSpeaking(servicesDto.isEntities());
        
        return feature;
    }
}
