package com.playleague.tournaments.services;

import com.playleague.tournaments.models.Participation;
import com.playleague.tournaments.models.Tournament;
import com.playleague.tournaments.models.User;
import com.playleague.tournaments.respositories.ParticipationRepository;
import com.playleague.tournaments.respositories.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new RuntimeException("Tournament not found"));
    }

    public Tournament updateMatchResults(Long tournamentId, String matchResults) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new RuntimeException("Tournament not found"));
        tournament.setMatchResults(matchResults);
        return tournamentRepository.save(tournament);
    }

    public Tournament updatePrizeDetails(Long tournamentId, String prizeDetails) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new RuntimeException("Tournament not found"));
        tournament.setPrizeDetails(prizeDetails);
        return tournamentRepository.save(tournament);
    }
}