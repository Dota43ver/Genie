package com.Genie.genetics.controller;

import com.Genie.genetics.dto.RequestDto;
import com.Genie.genetics.entity.Request;
import com.Genie.genetics.service.GeneticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Genie.genetics.dto.RequestScoreDto;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/requests")
@RequiredArgsConstructor
public class RequestController {
    private final GeneticService service;

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody RequestDto dto) {
        return ResponseEntity.ok(service.createRequest(dto));
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<Request> getRequest(@PathVariable String requestId) {
        return ResponseEntity.ok(service.getRequest(requestId));
    }

    @PutMapping("/{requestId}/score")
    public ResponseEntity<Request> updateRequestScore(
            @PathVariable String requestId,
            @RequestBody RequestScoreDto dto) {
        return ResponseEntity.ok(service.updateRequestScore(requestId, dto));
    }
}