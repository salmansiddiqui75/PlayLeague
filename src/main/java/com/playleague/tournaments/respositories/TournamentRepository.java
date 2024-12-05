package com.playleague.tournaments.respositories;

import com.playleague.tournaments.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}