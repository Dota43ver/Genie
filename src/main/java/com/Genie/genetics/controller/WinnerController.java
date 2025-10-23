package com.Genie.genetics.controller;

import com.Genie.genetics.dto.WinnerDto;
import com.Genie.genetics.entity.Winner;
import com.Genie.genetics.service.GeneticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/winners")
@RequiredArgsConstructor
@Tag(name = "Genetics - Winners", description = "Endpoints para gestionar los Ganadores (variaciones seleccionadas).")
public class WinnerController {
    private final GeneticService service;

    @Operation(
            summary = "Crear un nuevo Ganador",
            description = "Registra una 'Variación' como 'Ganadora' (Winner) de una generación, guardando su estado final."
    )
    @PostMapping
    public ResponseEntity<Winner> createWinner(@RequestBody WinnerDto dto) {
        return ResponseEntity.ok(service.createWinner(dto));
    }

    @Operation(
            summary = "Obtener todos los Ganadores",
            description = "Devuelve una lista completa de todos los registros de Ganadores."
    )
    @GetMapping
    public ResponseEntity<List<Winner>> getAllWinners() {
        return ResponseEntity.ok(service.getAllWinners());
    }

    @Operation(
            summary = "Obtener un Ganador por ID",
            description = "Busca y devuelve un registro de Ganador específico usando su 'winnerId'."
    )
    @GetMapping("/{winnerId}")
    public ResponseEntity<Winner> getWinner(@PathVariable String winnerId) {
        return ResponseEntity.ok(service.getWinner(winnerId));
    }
}
