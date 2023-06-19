package com.tinqin.academy.business.converters;

import com.tinqin.academy.api.category.create.CreateCategoryResult;
import com.tinqin.academy.api.entityoutputmodels.GameOutput;
import com.tinqin.academy.api.entityoutputmodels.SystemRequirementsOutput;
import com.tinqin.academy.data.models.Category;
import com.tinqin.academy.data.models.Game;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GameToGameOutput implements Converter<Game, GameOutput> {
    private final ConversionService conversionService;

    @Lazy
    public GameToGameOutput(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public GameOutput convert(Game source) {
        return GameOutput.builder()
                .id(source.getId())
                .name(source.getName())
                .publisher(source.getPublisher())
                .category(getCategories(source.getCategory()))
                .systemRequirements(getSystemRequirements(source.getSystemRequirements()))
                .releaseDate(source.getReleaseDate())
                .avgReviewDescription(source.getAvgReviewDescription())
                .build();
    }

    private Set<CreateCategoryResult> getCategories(Set<Category> source) {
        return source.stream().map(category -> conversionService.convert(category, CreateCategoryResult.class))
                .collect(Collectors.toSet());
    }

    private SystemRequirementsOutput getSystemRequirements(SystemRequirements source) {
        return conversionService.convert(source, SystemRequirementsOutput.class);
    }
}
