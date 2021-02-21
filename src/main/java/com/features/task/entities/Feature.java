package com.features.task.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "feature")

@Getter
@Setter
@NoArgsConstructor
@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonStringType.class)})
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_ua")
    private String nameUa;

    @Column(name = "name_en")
    private String nameEn;

    @Type(type = "jsonb")
    @Column(name = "work_hours", columnDefinition = "json")
    private List<List<Integer>> workHours;

    @Column(name = "is_online")
    private boolean isOnline;

    @Column(name = "is_visible")
    private boolean isVisible;

    private boolean vip;

    @Column(name = "all_hours")
    private boolean allHours;

    private boolean pi;

    private boolean entities;

    private boolean premium;

    @Column(name = "english_speaking")
    private boolean englishSpeaking;
}
