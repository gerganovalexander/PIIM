package com.tinqin.academy.business.operations.categories;

import com.tinqin.academy.api.category.update.UpdateCategoryInput;
import com.tinqin.academy.api.category.update.UpdateCategoryOperation;
import com.tinqin.academy.api.category.update.UpdateCategoryResult;
import com.tinqin.academy.data.models.Category;
import com.tinqin.academy.data.repositories.CategoryRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class UpdateCategoryOperationProcessor implements UpdateCategoryOperation {

    private final CategoryRepository categoryRepository;
    private final ConversionService conversionService;

    @Override
    public UpdateCategoryResult process(UpdateCategoryInput input) {
        if (input.getId() <= 0) throw new InvalidParameterException("Category id is invalid.");
        if (!categoryRepository.existsById(input.getId()))
            throw new EntityNotFoundException(String.format("Category with id %d does not exist.", input.getId()));
        if (categoryRepository.existsByName(input.getName()))
            throw new EntityExistsException(String.format("Category with name %s already exists.", input.getName()));

        Category category = Category.builder()
                .id(input.getId())
                .name(input.getName())
                .build();

        categoryRepository.save(category);

        return conversionService.convert(category, UpdateCategoryResult.class);
    }
}
