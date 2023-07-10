package com.tinqin.academy.piim.business.operations.systemrequirements.update;

import com.tinqin.academy.piim.api.errors.systemrequirements.UpdateSystemRequirementsError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsResult;
import com.tinqin.academy.piim.data.models.SystemRequirements;
import com.tinqin.academy.piim.data.repositories.SystemRequirementsRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
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
    public Either<PiimError, UpdateSystemRequirementsResult> process(UpdateSystemRequirementsInput input) {
        return Try.of(() -> {
                    boolean doesExists = systemRequirementsRepository.existsById(input.getId());
                    if (!doesExists) {
                        throw new EntityNotFoundException("System Requirements with this Id does not exist.");
                    }
                    SystemRequirements systemRequirementsObject =
                            conversionService.convert(input, SystemRequirements.class);
                    if (systemRequirementsObject == null) {
                        throw new InvalidParameterException();
                    }

                    systemRequirementsRepository.save(systemRequirementsObject);

                    return conversionService.convert(systemRequirementsObject, UpdateSystemRequirementsResult.class);
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new UpdateSystemRequirementsError(400, throwable.getMessage());
                });
    }
}
