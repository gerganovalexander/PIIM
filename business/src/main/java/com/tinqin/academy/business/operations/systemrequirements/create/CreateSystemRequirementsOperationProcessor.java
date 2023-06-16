package com.tinqin.academy.business.operations.systemrequirements.create;

import com.tinqin.academy.api.systemrequirements.create.CreateSystemRequirementsInput;
import com.tinqin.academy.api.systemrequirements.create.CreateSystemRequirementsOperation;
import com.tinqin.academy.api.systemrequirements.create.CreateSystemRequirementsResult;
import com.tinqin.academy.business.exceptions.DuplicateEntityException;
import com.tinqin.academy.data.models.SystemRequirements;
import com.tinqin.academy.data.repositories.SystemRequirementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateSystemRequirementsOperationProcessor implements CreateSystemRequirementsOperation {
    private final SystemRequirementsRepository systemRequirementsRepository;
    private final ConversionService conversionService;

    @Override
    public CreateSystemRequirementsResult process(CreateSystemRequirementsInput input) {
        SystemRequirements systemRequirements = conversionService.convert(input, SystemRequirements.class);
        if (systemRequirements == null) {
            throw new NullPointerException("Input is empty.");
        }
        boolean alreadyExist = systemRequirementsRepository.existsByCpuAndGpuAndOperatingSystemAndRam(
                systemRequirements.getCpu(),
                systemRequirements.getGpu(),
                systemRequirements.getOperatingSystem(),
                systemRequirements.getRam());
        if (alreadyExist) {
            throw new DuplicateEntityException("SystemRequirements with these properties already exists.");
        }
        systemRequirements = systemRequirementsRepository.save(systemRequirements);
        return conversionService.convert(systemRequirements, CreateSystemRequirementsResult.class);
    }
}
