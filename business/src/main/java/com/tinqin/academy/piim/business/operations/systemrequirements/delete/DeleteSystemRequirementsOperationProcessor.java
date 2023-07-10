package com.tinqin.academy.piim.business.operations.systemrequirements.delete;

import com.tinqin.academy.piim.api.errors.systemrequirements.DeleteSystemRequirementsError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsResult;
import com.tinqin.academy.piim.data.models.SystemRequirements;
import com.tinqin.academy.piim.data.repositories.SystemRequirementsRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteSystemRequirementsOperationProcessor implements DeleteSystemRequirementsOperation {

    private final SystemRequirementsRepository systemRequirementsRepository;

    @Override
    public Either<PiimError, DeleteSystemRequirementsResult> process(DeleteSystemRequirementsInput input) {
        return Try.of(() -> {
                    SystemRequirements systemRequirements = systemRequirementsRepository
                            .findById(input.getId())
                            .orElseThrow(() ->
                                    new EntityNotFoundException("System Requirements with this Id does not exist."));
                    systemRequirementsRepository.delete(systemRequirements);
                    return DeleteSystemRequirementsResult.builder()
                            .success(true)
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new DeleteSystemRequirementsError(400, throwable.getMessage());
                });
    }
}
