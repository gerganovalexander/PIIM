package com.tinqin.academy.piim.repositories;

import com.tinqin.academy.piim.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    boolean existsByName(String name);
}
