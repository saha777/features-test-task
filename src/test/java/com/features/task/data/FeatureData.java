package com.features.task.data;

import com.features.task.dto.FeatureDto;
import com.features.task.dto.ServicesDto;
import org.assertj.core.util.Lists;

public class FeatureData {

    public static FeatureDto withoutServices() {
        return FeatureDto.builder()
                .type("town")
                .companyId(30)
                .nameRu("имя")
                .nameUa("ім'я")
                .nameEn("name")
                .workHours(Lists.list(Lists.list(20, 10)))
                .isOnline(false)
                .isVisible(true)
                .build();
    }

    public static FeatureDto ok() {
        return FeatureDto.builder()
                .type("town")
                .companyId(30)
                .nameRu("имя")
                .nameUa("ім'я")
                .nameEn("name")
                .workHours(Lists.list(Lists.list(20, 10)))
                .isOnline(false)
                .isVisible(true)
                .servicesDto(
                        ServicesDto.builder()
                                .vip(true)
                                .allHours(true)
                                .entities(false)
                                .pi(false)
                                .premium(true)
                                .englishSpeaking(true)
                                .build()
                )
                .build();
    }

}
