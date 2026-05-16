package com.criss.demo.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.criss.demo.domain.model.Recipe;
import com.criss.demo.domain.service.RecipeService;
import com.criss.demo.dto.RecipeDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "Recetas", description = "Recetas de yogurt")
@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping
    @Operation(
        summary = "Crear receta",
        description = "Permite registrar una nueva receta de yogurt"
    )
    @ApiResponse(responseCode = "201", description = "Receta creada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = recipeService.createRecipe(recipeDTO);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar receta",
        description = "Actualiza los datos de una receta existente"
    )
    @ApiResponse(responseCode = "200", description = "Receta actualizada correctamente")
    @ApiResponse(responseCode = "404", description = "Receta no encontrada")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = recipeService.updateRecipe(id, recipeDTO);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Obtener receta por ID",
        description = "Retorna una receta específica según su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Receta encontrada")
    @ApiResponse(responseCode = "404", description = "Receta no encontrada")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipe(id);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    @Operation(
        summary = "Listar recetas",
        description = "Obtiene todas las recetas activas"
    )
    @ApiResponse(responseCode = "200", description = "Lista de recetas obtenida correctamente")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllActiveRecipes());
    }

    @GetMapping("/search")
    @Operation(
        summary = "Buscar recetas",
        description = "Permite buscar recetas por palabra clave"
    )
    @ApiResponse(responseCode = "200", description = "Resultados encontrados")
    @ApiResponse(responseCode = "400", description = "Parámetro inválido")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String keyword) {
        return ResponseEntity.ok(recipeService.searchRecipes(keyword));
    }

    @PatchMapping("/{id}/deactivate")
    @Operation(
        summary = "Desactivar receta",
        description = "Desactiva una receta existente"
    )
    @ApiResponse(responseCode = "200", description = "Receta desactivada correctamente")
    @ApiResponse(responseCode = "404", description = "Receta no encontrada")
    public ResponseEntity<Void> deactivateRecipe(@PathVariable Long id) {
        recipeService.deactivateRecipe(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/activate")
    @Operation(
        summary = "Activar receta",
        description = "Activa una receta previamente desactivada"
    )
    @ApiResponse(responseCode = "200", description = "Receta activada correctamente")
    @ApiResponse(responseCode = "404", description = "Receta no encontrada")
    public ResponseEntity<Void> activateRecipe(@PathVariable Long id) {
        recipeService.activateRecipe(id);
        return ResponseEntity.ok().build();
    }
}