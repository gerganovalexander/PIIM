package com.tinqin.academy.business.converters.gamepatch;

import com.tinqin.academy.api.entityoutputmodels.GameOutput;
import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.data.models.GamePatch;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GamePatchToGamePatchOutput implements Converter<GamePatch, GamePatchOutput> {
    private final ConversionService conversionService;

    @Lazy
    public GamePatchToGamePatchOutput(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public GamePatchOutput convert(GamePatch source) {
        return GamePatchOutput.builder()
                .id(source.getId())
                .version(source.getVersion())
                .description(source.getDescription())
                .uploadedAt(source.getUploadedAt())
                .game(conversionService.convert(source.getGame(), GameOutput.class)).build();
    }
}
