package com.playleague.tournaments.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role; // Either "USER" or "ADMIN"


    @JsonManagedReference
  @JsonIgnore
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
        name = "user_tournaments",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "tournament_id")
)
private List<Tournament> tournaments = new ArrayList<>();

    public void joinTournament(Tournament tournament) {
        tournaments.add(tournament);
        tournament.getParticipants().add(this);
    }

    public void leaveTournament(Tournament tournament) {
        tournaments.remove(tournament);
        tournament.getParticipants().remove(this);
    }
}
