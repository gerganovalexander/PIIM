package com.tinqin.academy.piim.data.repositories;

import com.tinqin.academy.piim.data.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findFirstByName(String name);

    boolean existsByName(String name);
}
