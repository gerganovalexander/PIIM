package com.tinqin.academy.business.services;

import com.tinqin.academy.business.services.contracts.SystemRequirementsService;
import com.tinqin.academy.data.models.SystemRequirements;
import com.tinqin.academy.data.repositories.SystemRequirementsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemRequirementsServiceImpl implements SystemRequirementsService {

    private final SystemRequirementsRepository systemRequirementsRepository;

    @Override
    public List<SystemRequirements> getAll() {
        return systemRequirementsRepository.findAll();
    }

    @Override
    public SystemRequirements getSystemRequirementsById(Long systemRequirementsId) {
        return systemRequirementsRepository.findById(systemRequirementsId)
                .orElseThrow(() -> new EntityNotFoundException("System Requirements with this Id does not exist."));
    }

    @Override
    public SystemRequirements create(SystemRequirements systemRequirementsObject) {
        return systemRequirementsRepository.save(systemRequirementsObject);
    }

    @Override
    public void update(SystemRequirements systemRequirementsObject) {
        Optional<SystemRequirements> requirementsToUpdate = systemRequirementsRepository.findById(systemRequirementsObject.getSystemRequirementsId());
        if (requirementsToUpdate.isPresent()) {
            systemRequirementsRepository.save(systemRequirementsObject);
        }
    }


    @Override
    public void delete(Long systemRequirementsId) {
        SystemRequirements systemRequirementsObject = getSystemRequirementsById(systemRequirementsId);
        systemRequirementsRepository.delete(systemRequirementsObject);
    }


}