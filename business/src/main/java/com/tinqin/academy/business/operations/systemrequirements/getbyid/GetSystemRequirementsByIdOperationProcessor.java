package com.tinqin.academy.business.operations.systemrequirements.getbyid;

import com.tinqin.academy.api.systemrequirements.getbyid.GetSystemRequirementsByIdInput;
import com.tinqin.academy.api.systemrequirements.getbyid.GetSystemRequirementsByIdOperation;
import com.tinqin.academy.api.systemrequirements.getbyid.GetSystemRequirementsByIdResult;
import com.tinqin.academy.data.models.SystemRequirements;
import com.tinqin.academy.data.repositories.SystemRequirementsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetSystemRequirementsByIdOperationProcessor implements GetSystemRequirementsByIdOperation {

    private final SystemRequirementsRepository systemRequirementsRepository;
    private final ConversionService conversionService;

    @Override
    public GetSystemRequirementsByIdResult process(GetSystemRequirementsByIdInput input) {
        SystemRequirements systemRequirements = systemRequirementsRepository.findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("System Requirements with this Id does not exist."));
        return conversionService.convert(systemRequirements, GetSystemRequirementsByIdResult.class);
    }
}
