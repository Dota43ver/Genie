package com.Genie.genetics.controller;

import com.Genie.genetics.dto.AgentDto;
import com.Genie.genetics.entity.Agent;
import com.Genie.genetics.service.GeneticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Genie.genetics.dto.AgentStatusDto;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/agents")
@RequiredArgsConstructor
public class AgentController {
    private final GeneticService service;

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody AgentDto dto) {
        return ResponseEntity.ok(service.createAgent(dto));
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        return ResponseEntity.ok(service.getAllAgents());
    }

    @GetMapping("/{agentId}")
    public ResponseEntity<Agent> getAgent(@PathVariable String agentId) {
        return ResponseEntity.ok(service.getAgent(agentId));
    }

    @PutMapping("/{agentId}")
    public ResponseEntity<Agent> updateAgent(@PathVariable String agentId, @RequestBody AgentDto dto) {
        return ResponseEntity.ok(service.updateAgent(agentId, dto));
    }

    @PutMapping("/{agentId}/status")
    public ResponseEntity<Agent> updateAgentStatus(
            @PathVariable String agentId,
            @RequestBody AgentStatusDto dto) {
        return ResponseEntity.ok(service.updateAgentStatus(agentId, dto));
    }
}
