package com.tinqin.academy.piim.business.converters.categories;

import com.tinqin.academy.piim.api.category.update.UpdateCategoryResult;
import com.tinqin.academy.piim.data.models.Category;
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
