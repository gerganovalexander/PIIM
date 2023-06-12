package com.tinqin.academy.piim.services.contracts;

import com.tinqin.academy.piim.models.SystemRequirements;

import java.util.List;

public interface SystemRequirementsService {
    List<SystemRequirements> getAll();

    SystemRequirements getSystemRequirementsById(Long systemRequirementsId);

    SystemRequirements create(SystemRequirements systemRequirementsObject);

    void update(SystemRequirements systemRequirementsObject);

    void delete(Long systemRequirementsId);
}
