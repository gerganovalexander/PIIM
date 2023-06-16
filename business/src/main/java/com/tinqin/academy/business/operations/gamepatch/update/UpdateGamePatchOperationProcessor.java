package com.tinqin.academy.business.operations.gamepatch.update;

import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.api.gamepatch.update.UpdateGamePatchInput;
import com.tinqin.academy.api.gamepatch.update.UpdateGamePatchOperation;
import com.tinqin.academy.api.gamepatch.update.UpdateGamePatchResult;
import com.tinqin.academy.data.models.GamePatch;
import com.tinqin.academy.data.repositories.GamePatchRepository;
import com.tinqin.academy.data.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateGamePatchOperationProcessor implements UpdateGamePatchOperation {
    private final ConversionService conversionService;
    private final GameRepository gameRepository;
    private final GamePatchRepository gamePatchRepository;

    @Override
    public UpdateGamePatchResult process(UpdateGamePatchInput input) {
        GamePatch gamePatchForUpdate = gamePatchRepository.findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("Game patch with this Id does not exist."));

        gamePatchForUpdate.setDescription(input.getDescription());
        gamePatchForUpdate = gamePatchRepository.save(gamePatchForUpdate);

        return UpdateGamePatchResult.builder()
                .gamePatchOutput(conversionService.convert(gamePatchForUpdate, GamePatchOutput.class))
                .build();
    }
}