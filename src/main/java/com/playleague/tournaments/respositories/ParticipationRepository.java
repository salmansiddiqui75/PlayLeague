package com.playleague.tournaments.respositories;

import com.playleague.tournaments.models.Participation;
import com.playleague.tournaments.models.Tournament;
import com.playleague.tournaments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findByUser(User user);
    Optional<Participation> findByUserAndTournament(User user, Tournament tournament);
}
