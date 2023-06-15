package com.tinqin.academy.business.converters;

import com.tinqin.academy.api.category.create.CreateCategoryInput;
import com.tinqin.academy.data.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryInputToCategoryConverter implements Converter<CreateCategoryInput, Category> {

    @Override
    public Category convert(CreateCategoryInput categoryInput) {
        return Category.builder()
                .name(categoryInput.getName())
                .build();
    }
}
