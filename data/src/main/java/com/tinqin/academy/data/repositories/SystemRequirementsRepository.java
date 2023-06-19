package com.tinqin.academy.data.repositories;

import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemRequirementsRepository extends JpaRepository<SystemRequirements, Long> {

    boolean existsByCpuAndGpuAndOperatingSystemAndRam(String cpu, String gpu, String os, Integer ram);
}
