package com.tinqin.academy.data.repositories;

import com.tinqin.academy.data.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findFirstByName(String name);

    boolean existsByName(String name);
}
