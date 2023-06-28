package com.tinqin.academy.piim.business.converters.categories;

import com.tinqin.academy.piim.api.entityoutputmodels.CategoryOutput;
import com.tinqin.academy.piim.data.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryOutputConverter implements Converter<Category, CategoryOutput> {
    @Override
    public CategoryOutput convert(Category source) {
        return CategoryOutput.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
