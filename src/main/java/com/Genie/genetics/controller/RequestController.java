package com.Genie.genetics.controller;

import com.Genie.genetics.dto.RequestDto;
import com.Genie.genetics.entity.Request;
import com.Genie.genetics.service.GeneticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Genie.genetics.dto.RequestScoreDto;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/requests")
@RequiredArgsConstructor
@Tag(name = "Genetics - Requests", description = "Endpoints para gestionar las Peticiones (logs de uso y feedback).")
public class RequestController {
    private final GeneticService service;

    @Operation(
            summary = "Crear una nueva Petición",
            description = "Registra una nueva 'Petición' (Request), que almacena el prompt usado, la entrada del usuario y el contenido generado."
    )
    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody RequestDto dto) {
        return ResponseEntity.ok(service.createRequest(dto));
    }

    @Operation(
            summary = "Obtener todas las Peticiones",
            description = "Devuelve una lista completa de todas las Peticiones (Requests) registradas."
    )
    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    @Operation(
            summary = "Obtener una Petición por ID",
            description = "Busca y devuelve una Petición específica usando su 'requestId'."
    )
    @GetMapping("/{requestId}")
    public ResponseEntity<Request> getRequest(@PathVariable String requestId) {
        return ResponseEntity.ok(service.getRequest(requestId));
    }

    @Operation(
            summary = "Actualizar puntuación (score) de una Petición",
            description = "Permite asignar o actualizar la puntuación (score) de una Petición, usado para el feedback del algoritmo genético."
    )
    @PutMapping("/{requestId}/score")
    public ResponseEntity<Request> updateRequestScore(
            @PathVariable String requestId,
            @RequestBody RequestScoreDto dto) {
        return ResponseEntity.ok(service.updateRequestScore(requestId, dto));
    }
}