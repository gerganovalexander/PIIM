package com.tinqin.academy.piim.business.converters.categories;


import com.tinqin.academy.piim.api.category.create.CreateCategoryResult;
import com.tinqin.academy.piim.data.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCreateCategoryResultConverter implements Converter<Category, CreateCategoryResult> {
    @Override
    public CreateCategoryResult convert(Category category) {
        return CreateCategoryResult.builder()
                .id(category.getId())
                .name(category.getName()).build();
    }

}
