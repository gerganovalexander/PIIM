package com.tinqin.academy.piim.business.converters.gamepatch;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesResult;
import com.tinqin.academy.piim.data.models.GamePatch;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GamePatchToGetAllGamePatchesResult implements Converter<GamePatch, GetAllGamePatchesResult> {
    private final ConversionService conversionService;

    @Lazy
    public GamePatchToGetAllGamePatchesResult(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public GetAllGamePatchesResult convert(GamePatch source) {
        return GetAllGamePatchesResult.builder()
                .gamePatch(conversionService.convert(source, GamePatchOutput.class))
                .build();
    }
}
