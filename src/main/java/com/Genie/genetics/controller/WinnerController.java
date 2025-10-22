package com.Genie.genetics.controller;

import com.Genie.genetics.dto.WinnerDto;
import com.Genie.genetics.entity.Winner;
import com.Genie.genetics.service.GeneticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genetics/winners")
@RequiredArgsConstructor
public class WinnerController {
    private final GeneticService service;

    @PostMapping
    public ResponseEntity<Winner> createWinner(@RequestBody WinnerDto dto) {
        return ResponseEntity.ok(service.createWinner(dto));
    }

    @GetMapping
    public ResponseEntity<List<Winner>> getAllWinners() {
        return ResponseEntity.ok(service.getAllWinners());
    }

    @GetMapping("/{winnerId}")
    public ResponseEntity<Winner> getWinner(@PathVariable String winnerId) {
        return ResponseEntity.ok(service.getWinner(winnerId));
    }
}
