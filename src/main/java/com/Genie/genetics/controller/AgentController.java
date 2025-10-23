package com.Genie.genetics.controller;

import com.Genie.genetics.dto.AgentDto;
import com.Genie.genetics.entity.Agent;
import com.Genie.genetics.service.GeneticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Genie.genetics.dto.AgentStatusDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/agents")
@RequiredArgsConstructor
@Tag(name = "Genetics - Agents", description = "Gestiona los 'Agentes' del algoritmo genético.")
public class AgentController {
    private final GeneticService service;

    @Operation(
            summary = "crea un nuevo agente",
            description = "Registra un nuevo agente con su ID, nombre, prompt base y configuración inicial."
    )
    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody AgentDto dto) {
        return ResponseEntity.ok(service.createAgent(dto));
    }

    @Operation(
            summary = "Obtiene todos los Agentes",
            description = "Devuelve una lista completa de todos los Agentes registrados en el sistema."
    )
    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        return ResponseEntity.ok(service.getAllAgents());
    }

    @Operation(
            summary = "Obtiene un Agente por ID",
            description = "Busca y devuelve un Agente específico usando su 'agentId' (el ID único de texto, no el Long de la BD)."
    )
    @GetMapping("/{agentId}")
    public ResponseEntity<Agent> getAgent(@PathVariable String agentId) {
        return ResponseEntity.ok(service.getAgent(agentId));
    }

    @Operation(
            summary = "Actualizar un Agente",
            description = "Actualiza la información principal de un Agente (nombre, prompt base, generación activa, etc.)."
    )
    @PutMapping("/{agentId}")
    public ResponseEntity<Agent> updateAgent(@PathVariable String agentId, @RequestBody AgentDto dto) {
        return ResponseEntity.ok(service.updateAgent(agentId, dto));
    }

    @Operation(
            summary = "Actualizar estado del Agente",
            description = "Actualiza campos de estado específicos de un Agente, como su 'generación activa'."
    )
    @PutMapping("/{agentId}/status")
    public ResponseEntity<Agent> updateAgentStatus(
            @PathVariable String agentId,
            @RequestBody AgentStatusDto dto) {
        return ResponseEntity.ok(service.updateAgentStatus(agentId, dto));
    }
}
