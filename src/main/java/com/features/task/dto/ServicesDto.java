package com.features.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ServicesDto {

    private boolean vip;

    @JsonProperty("all_hours")
    private boolean allHours;

    private boolean pi;

    private boolean entities;

    private boolean premium;

    @JsonProperty("english_speaking")
    private boolean englishSpeaking;
}
