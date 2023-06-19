package com.tinqin.academy.business.operations.systemrequirements.delete;

import com.tinqin.academy.api.systemrequirements.delete.DeleteSystemRequirementsInput;
import com.tinqin.academy.api.systemrequirements.delete.DeleteSystemRequirementsOperation;
import com.tinqin.academy.api.systemrequirements.delete.DeleteSystemRequirementsResult;
import com.tinqin.academy.data.models.SystemRequirements;
import com.tinqin.academy.data.repositories.SystemRequirementsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteSystemRequirementsOperationProcessor implements DeleteSystemRequirementsOperation {

    private final SystemRequirementsRepository systemRequirementsRepository;

    @Override
    public DeleteSystemRequirementsResult process(DeleteSystemRequirementsInput input) {
        SystemRequirements systemRequirements = systemRequirementsRepository.findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("System Requirements with this Id does not exist."));
        systemRequirementsRepository.delete(systemRequirements);

        return DeleteSystemRequirementsResult.builder()
                .success(true)
                .build();
    }
}
