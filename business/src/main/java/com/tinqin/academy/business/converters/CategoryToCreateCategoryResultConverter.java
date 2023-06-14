package com.tinqin.academy.business.converters;


import com.tinqin.academy.api.category.create.CreateCategoryResult;
import com.tinqin.academy.data.models.Category;
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
