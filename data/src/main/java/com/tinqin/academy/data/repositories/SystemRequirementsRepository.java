package com.tinqin.academy.data.repositories;

import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRequirementsRepository extends JpaRepository<SystemRequirements, Long> {

    boolean existsBySystemRequirementsId(Long id);

    boolean existsByCpuAndGpuAndOperatingSystemAndRam(String cpu, String gpu, String os, Integer ram);
}
