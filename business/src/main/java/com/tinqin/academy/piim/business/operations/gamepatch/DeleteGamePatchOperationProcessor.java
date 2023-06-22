package com.tinqin.academy.piim.business.operations.gamepatch;

import com.tinqin.academy.piim.api.gamepatch.delete.DeleteGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.delete.DeleteGamePatchOperation;
import com.tinqin.academy.piim.api.gamepatch.delete.DeleteGamePatchResult;
import com.tinqin.academy.piim.data.models.GamePatch;
import com.tinqin.academy.piim.data.repositories.GamePatchRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteGamePatchOperationProcessor implements DeleteGamePatchOperation {
    private final GamePatchRepository gamePatchRepository;

    @Override
    public DeleteGamePatchResult process(DeleteGamePatchInput input) {
        GamePatch gamePatchToDelete = gamePatchRepository
                .findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("Game patch with this Id does not exist."));

        gamePatchRepository.delete(gamePatchToDelete);

        return DeleteGamePatchResult.builder().success(true).build();
    }
}
