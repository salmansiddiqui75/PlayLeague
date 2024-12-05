package com.playleague.tournaments.respositories;

import com.playleague.tournaments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails getUserByUsername(String username);
}
