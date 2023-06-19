package com.tinqin.academy.business.operations.gamepatch;

import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.api.gamepatch.getbyid.GetGamePatchByIdInput;
import com.tinqin.academy.api.gamepatch.getbyid.GetGamePatchByIdOperation;
import com.tinqin.academy.api.gamepatch.getbyid.GetGamePatchByIdResult;
import com.tinqin.academy.data.models.GamePatch;
import com.tinqin.academy.data.repositories.GamePatchRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetGamePatchByIdOperationProcessor implements GetGamePatchByIdOperation {
    private final ConversionService conversionService;
    private final GamePatchRepository gamePatchRepository;

    @Override
    public GetGamePatchByIdResult process(GetGamePatchByIdInput input) {
        GamePatch gamePatch = gamePatchRepository.findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("Game patch with this Id does not exist."));

        return GetGamePatchByIdResult.builder()
                .gamePatch(conversionService.convert(gamePatch, GamePatchOutput.class)).build();
    }
}
