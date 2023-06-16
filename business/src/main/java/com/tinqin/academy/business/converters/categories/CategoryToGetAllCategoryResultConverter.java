package com.tinqin.academy.business.converters.categories;

import com.tinqin.academy.api.category.getall.GetAllCategoryResult;
import com.tinqin.academy.data.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToGetAllCategoryResultConverter implements Converter<Category, GetAllCategoryResult> {
    @Override
    public GetAllCategoryResult convert(Category source) {
        return GetAllCategoryResult.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
