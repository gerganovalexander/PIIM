package com.tinqin.academy.business.services.contracts;

import com.tinqin.academy.data.models.SystemRequirements;

import java.util.List;

public interface SystemRequirementsService {
    List<SystemRequirements> getAll();

    SystemRequirements getSystemRequirementsById(Long systemRequirementsId);

    SystemRequirements create(SystemRequirements systemRequirementsObject);

    void update(SystemRequirements systemRequirementsObject);

    void delete(Long systemRequirementsId);
}
