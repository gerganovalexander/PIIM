package com.tinqin.academy.business.operations.systemrequirements.update;

import com.tinqin.academy.api.systemrequirements.update.UpdateSystemRequirementsInput;
import com.tinqin.academy.api.systemrequirements.update.UpdateSystemRequirementsOperation;
import com.tinqin.academy.api.systemrequirements.update.UpdateSystemRequirementsResult;
import com.tinqin.academy.data.models.SystemRequirements;
import com.tinqin.academy.data.repositories.SystemRequirementsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class UpdateSystemRequirementsOperationProcessor implements UpdateSystemRequirementsOperation {

    private final SystemRequirementsRepository systemRequirementsRepository;
    private final ConversionService conversionService;

    @Override
    public UpdateSystemRequirementsResult process(UpdateSystemRequirementsInput input) {
        boolean doesExists = systemRequirementsRepository.existsById(input.getId());
        if (!doesExists) {
            throw new EntityNotFoundException("System Requirements with this Id does not exist.");
        }
        SystemRequirements systemRequirementsObject = conversionService.convert(input, SystemRequirements.class);
        if (systemRequirementsObject == null) {
            throw new InvalidParameterException();
        }

        systemRequirementsRepository.save(systemRequirementsObject);

        return conversionService.convert(systemRequirementsObject, UpdateSystemRequirementsResult.class);
    }
}
