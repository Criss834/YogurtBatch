package com.criss.demo.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("recipe")
    @Builder.Default
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(nullable = false)
    private Double defaultMilkVolume;

    @Column(nullable = false)
    private Double defaultStarterAmount;

    @Column(nullable = false)
    private Double heatingTemperature;

    @Column(nullable = false)
    private Integer heatingDuration;

    @Column(nullable = false)
    private Double inoculationTemperature;

    @Column(nullable = false)
    private Double incubationTemperature;

    @Column(nullable = false)
    private Integer minIncubationTime;

    @Column(nullable = false)
    private Integer maxIncubationTime;

    @Column(nullable = false)
    private Integer refrigerationTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyLevel difficulty;

    private String tips;

    @Column(nullable = false)
    private Boolean active;

    public enum DifficultyLevel {
        BEGINNER, INTERMEDIATE, ADVANCED
    }
}