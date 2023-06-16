package com.tinqin.academy.business.operations.gamepatch.getall;

import com.tinqin.academy.api.gamepatch.getall.GetAllGamePatchesInput;
import com.tinqin.academy.api.gamepatch.getall.GetAllGamePatchesOperation;
import com.tinqin.academy.api.gamepatch.getall.GetAllGamePatchesResult;
import com.tinqin.academy.api.gamepatch.getall.GetAllGamePatchesResults;
import com.tinqin.academy.data.repositories.GamePatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllGamePatchesOperationProcessor implements GetAllGamePatchesOperation {
    private final ConversionService conversionService;
    private final GamePatchRepository gamePatchRepository;

    @Override
    public GetAllGamePatchesResults process(GetAllGamePatchesInput input) {
        List<GetAllGamePatchesResult> results = gamePatchRepository.findAll().stream()
                .map(gamePatch -> conversionService.convert(gamePatch, GetAllGamePatchesResult.class))
                .collect(Collectors.toList());

        return GetAllGamePatchesResults.builder()
                .results(results).build();
    }
}
