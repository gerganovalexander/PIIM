package com.tinqin.academy.piim.business.converters.categories;

import com.tinqin.academy.piim.api.category.getall.GetAllCategoryResult;
import com.tinqin.academy.piim.data.models.Category;
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
