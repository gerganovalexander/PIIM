package com.tinqin.academy.business.mappers;

import com.tinqin.academy.api.dtos.CategoryDto;
import com.tinqin.academy.data.models.Category;

public class CategoryMapper {

    public static Category dtoToCategory(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }

    public static Category dtoToCategory(CategoryDto dto, long id) {
        Category category = dtoToCategory(dto);
        category.setId(id);
        return category;
    }

    public static CategoryDto categoryToDto(Category category) {
        return new CategoryDto(category.getName());
    }
}
