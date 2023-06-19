package com.tinqin.academy.piim.data.repositories;

import com.tinqin.academy.piim.data.models.GamePatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePatchRepository extends JpaRepository<GamePatch, Long> {

    boolean existsGamePatchByVersion(String version);

}
