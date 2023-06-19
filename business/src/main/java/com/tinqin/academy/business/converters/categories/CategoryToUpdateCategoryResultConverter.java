package com.tinqin.academy.business.converters.categories;

import com.tinqin.academy.api.category.update.UpdateCategoryResult;
import com.tinqin.academy.data.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToUpdateCategoryResultConverter implements Converter<Category, UpdateCategoryResult> {

    @Override
    public UpdateCategoryResult convert(Category source) {
        return UpdateCategoryResult.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
