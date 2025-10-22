package com.Genie.genetics.controller;

import com.Genie.genetics.dto.VariationDto;
import com.Genie.genetics.entity.Variation;
import com.Genie.genetics.service.GeneticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Genie.genetics.dto.VariationStatusDto;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/variations")
@RequiredArgsConstructor
public class VariationController {
    private final GeneticService service;

    @PostMapping
    public ResponseEntity<Variation> createVariation(@RequestBody VariationDto dto) {
        return ResponseEntity.ok(service.createVariation(dto));
    }

    @GetMapping
    public ResponseEntity<List<Variation>> getAllVariations() {
        return ResponseEntity.ok(service.getAllVariations());
    }

    @GetMapping("/{variationId}")
    public ResponseEntity<Variation> getVariation(@PathVariable String variationId) {
        return ResponseEntity.ok(service.getVariation(variationId));
    }

    @PutMapping("/{variationId}/status")
    public ResponseEntity<Variation> updateVariationStatus(
            @PathVariable String variationId,
            @RequestBody VariationStatusDto dto) {
        return ResponseEntity.ok(service.updateVariationStatus(variationId, dto));
    }

}