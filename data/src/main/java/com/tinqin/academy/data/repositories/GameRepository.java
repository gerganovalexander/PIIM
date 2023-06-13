package com.tinqin.academy.data.repositories;

import com.tinqin.academy.data.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    boolean existsByName(String name);
}
