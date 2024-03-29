package com.tinqin.academy.piim.business.operations.systemrequirements.create;

import com.tinqin.academy.piim.api.errors.systemrequirements.CreateSystemRequirementsError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsResult;
import com.tinqin.academy.piim.data.models.SystemRequirements;
import com.tinqin.academy.piim.data.repositories.SystemRequirementsRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class CreateSystemRequirementsOperationProcessor implements CreateSystemRequirementsOperation {

    private final SystemRequirementsRepository systemRequirementsRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, CreateSystemRequirementsResult> process(CreateSystemRequirementsInput input) {
        return Try.of(() -> {
                    SystemRequirements systemRequirements = conversionService.convert(input, SystemRequirements.class);
                    if (systemRequirements == null) {
                        throw new InvalidParameterException("Input is empty.");
                    }
                    boolean alreadyExist = systemRequirementsRepository.existsByCpuAndGpuAndOperatingSystemAndRam(
                            systemRequirements.getCpu(),
                            systemRequirements.getGpu(),
                            systemRequirements.getOperatingSystem(),
                            systemRequirements.getRam());
                    if (alreadyExist) {
                        throw new EntityExistsException("System requirements with those properties already exists.");
                    }

                    systemRequirements = systemRequirementsRepository.save(systemRequirements);
                    return conversionService.convert(systemRequirements, CreateSystemRequirementsResult.class);
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new CreateSystemRequirementsError(400, throwable.getMessage());
                });
    }
}
