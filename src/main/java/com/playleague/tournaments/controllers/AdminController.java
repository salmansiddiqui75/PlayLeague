package com.playleague.tournaments.controllers;

import com.playleague.tournaments.models.Tournament;
import com.playleague.tournaments.services.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final TournamentService tournamentService;

    @PostMapping("/tournaments")
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        return ResponseEntity.ok(tournamentService.createTournament(tournament));
    }

    @GetMapping("/tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @PutMapping("/tournaments/{id}/match-results")
    public ResponseEntity<Tournament> updateMatchResults(@PathVariable Long id, @RequestParam String matchResults) {
        return ResponseEntity.ok(tournamentService.updateMatchResults(id, matchResults));
    }

    @PutMapping("/tournaments/{id}/prize-details")
    public ResponseEntity<Tournament> updatePrizeDetails(@PathVariable Long id, @RequestParam String prizeDetails) {
        return ResponseEntity.ok(tournamentService.updatePrizeDetails(id, prizeDetails));
    }
}
