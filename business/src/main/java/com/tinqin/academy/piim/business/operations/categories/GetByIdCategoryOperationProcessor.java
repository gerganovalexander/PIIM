package com.tinqin.academy.piim.business.operations.categories;

import com.tinqin.academy.piim.api.category.getbyid.GetByIdCategoryInput;
import com.tinqin.academy.piim.api.category.getbyid.GetByIdCategoryOperation;
import com.tinqin.academy.piim.api.category.getbyid.GetByIdCategoryResult;
import com.tinqin.academy.piim.data.models.Category;
import com.tinqin.academy.piim.data.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetByIdCategoryOperationProcessor implements GetByIdCategoryOperation {

    private final CategoryRepository categoryRepository;

    @Override
    public GetByIdCategoryResult process(GetByIdCategoryInput input) {
        Category category = categoryRepository
                .findById(input.getId())
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format("Category with id %d not found.", input.getId())));

        return GetByIdCategoryResult.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
