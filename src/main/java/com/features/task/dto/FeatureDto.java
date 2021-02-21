package com.features.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FeatureDto {
    private int id;

    @Size(max = 100)
    private String type;

    @JsonProperty("company_id")
    private int companyId;

    @Size(max = 65535)
    @JsonProperty("name_ru")
    private String nameRu;

    @Size(max = 65535)
    @JsonProperty("name_ua")
    private String nameUa;

    @Size(max = 65535)
    @JsonProperty("name_en")
    private String nameEn;

    @NotNull
    @JsonProperty("work_hours")
    private List<List<Integer>> workHours;

    @JsonProperty("is_online")
    private boolean isOnline;

    @JsonProperty("is_visible")
    private boolean isVisible;

    @NotNull
    private ServicesDto servicesDto;
}
