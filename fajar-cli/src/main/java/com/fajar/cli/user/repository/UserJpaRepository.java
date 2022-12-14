package com.fajar.cli.user.repository;

import com.fajar.cli.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
