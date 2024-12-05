package com.playleague.tournaments.respositories;

import com.playleague.tournaments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>
{

    User getUserByUsername(String username);

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.tournaments WHERE u.id = :id")
    Optional<User> findUserWithTournaments(@Param("id") Long id);
}
