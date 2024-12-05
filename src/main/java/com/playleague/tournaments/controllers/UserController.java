package com.playleague.tournaments.controllers;

import com.playleague.tournaments.models.Tournament;
import com.playleague.tournaments.models.User;
import com.playleague.tournaments.services.TournamentService;
import com.playleague.tournaments.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TournamentService tournamentService;

    @GetMapping("/tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @GetMapping("/tournaments/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        return ResponseEntity.ok(tournamentService.getTournamentById(id));
    }

    @PostMapping("/{userId}/join/{tournamentId}")
    public ResponseEntity<String> joinTournament(@PathVariable Long userId, @PathVariable Long tournamentId) {
        String message = userService.joinTournament(userId, tournamentId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}/tournaments")
    public ResponseEntity<User> getUserWithTournaments(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserWithTournaments(id));
    }
}
