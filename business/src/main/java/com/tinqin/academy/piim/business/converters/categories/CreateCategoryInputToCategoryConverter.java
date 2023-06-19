package com.tinqin.academy.piim.business.converters.categories;

import com.tinqin.academy.piim.api.category.create.CreateCategoryInput;
import com.tinqin.academy.piim.data.models.Category;
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
