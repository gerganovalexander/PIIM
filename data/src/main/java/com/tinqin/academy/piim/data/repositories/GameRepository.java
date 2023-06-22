package com.tinqin.academy.piim.data.repositories;

import com.tinqin.academy.piim.data.models.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findFirstByName(String name);

    boolean existsByName(String name);

    @Query(value = "SELECT g FROM Game g WHERE g.id IN (:ids)")
    Page<Game> findAllByIds(List<Long> ids, Pageable pageable);

    @Query(value = "SELECT DISTINCT g FROM Game g JOIN Category c WHERE :categoryName LIKE c.name ")
    Page<Game> findAllByCategoryName(String categoryName, Pageable pageable);
}
