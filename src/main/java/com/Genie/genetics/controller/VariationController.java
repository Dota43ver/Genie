package com.Genie.genetics.controller;

import com.Genie.genetics.dto.VariationDto;
import com.Genie.genetics.entity.Variation;
import com.Genie.genetics.service.GeneticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Genie.genetics.dto.VariationStatusDto;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/variations")
@RequiredArgsConstructor
@Tag(name = "Genetics - Variations", description = "Endpoints para gestionar las Variaciones (las versiones de prompts generadas).")
public class VariationController {
    private final GeneticService service;

    @Operation(
            summary = "Crear una nueva Variación",
            description = "Registra una nueva 'Variación' (una versión de prompt) asociada a un Agente y una generación."
    )
    @PostMapping
    public ResponseEntity<Variation> createVariation(@RequestBody VariationDto dto) {
        return ResponseEntity.ok(service.createVariation(dto));
    }

    @Operation(
            summary = "Obtener todas las Variaciones",
            description = "Devuelve una lista completa de todas las Variaciones de prompts registradas."
    )
    @GetMapping
    public ResponseEntity<List<Variation>> getAllVariations() {
        return ResponseEntity.ok(service.getAllVariations());
    }

    @Operation(
            summary = "Obtener una Variación por ID",
            description = "Busca y devuelve una Variación específica usando su 'variationId'."
    )
    @GetMapping("/{variationId}")
    public ResponseEntity<Variation> getVariation(@PathVariable String variationId) {
        return ResponseEntity.ok(service.getVariation(variationId));
    }

    @Operation(
            summary = "Actualizar estado de una Variación",
            description = "Actualiza campos de estado de una Variación, como 'isActive', 'avgScore' o 'useCount'."
    )
    @PutMapping("/{variationId}/status")
    public ResponseEntity<Variation> updateVariationStatus(
            @PathVariable String variationId,
            @RequestBody VariationStatusDto dto) {
        return ResponseEntity.ok(service.updateVariationStatus(variationId, dto));
    }

}