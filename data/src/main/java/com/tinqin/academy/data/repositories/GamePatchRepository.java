package com.tinqin.academy.data.repositories;

import com.tinqin.academy.data.models.GamePatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePatchRepository extends JpaRepository<GamePatch, Long> {

    boolean existsGamePatchByVersion(String version);

    boolean existsGamePatchById(Long id);
}
