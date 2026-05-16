package com.criss.demo.dto;

import java.util.List;

import com.criss.demo.domain.model.Recipe;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {

    @Schema(description = "Nombre de la receta", example = "Yogurt de fresa")
    private String name;

    @Schema(description = "Descripción detallada de la receta", example = "Receta de yogurt natural con frutas")
    private String description;

    @Schema(description = "Cantidad de leche por defecto en litros", example = "1.0")
    
    private Double defaultMilkVolume;

    @Schema(description = "Cantidad de cultivo iniciador en gramos", example = "0.5")

    private Double defaultStarterAmount;

    @Schema(description = "Temperatura de calentamiento en grados Celsius", example = "85.0")
    private Double heatingTemperature;

    @Schema(description = "Tiempo de calentamiento en minutos", example = "30")
    private Integer heatingDuration;

    @Schema(description = "Temperatura de inoculación en grados Celsius", example = "45.0")
    private Double inoculationTemperature;

    @Schema(description = "Temperatura de incubación en grados Celsius", example = "42.0")
    private Double incubationTemperature;

    @Schema(description = "Tiempo mínimo de incubación en horas", example = "6")
    private Integer minIncubationTime;

    @Schema(description = "Tiempo máximo de incubación en horas", example = "12")
    private Integer maxIncubationTime;

    @Schema(description = "Tiempo de refrigeración en horas", example = "4")
    private Integer refrigerationTime;

    @Schema(description = "Nivel de dificultad de la receta", example = "MEDIUM")
    private Recipe.DifficultyLevel difficulty;

    @Schema(description = "Consejos o recomendaciones para la preparación", example = "Mantener temperatura constante durante la incubación")
    private String tips;

    @Schema(description = "Lista de ingredientes necesarios para la receta")
    private List<IngredientDTO> ingredients;
}