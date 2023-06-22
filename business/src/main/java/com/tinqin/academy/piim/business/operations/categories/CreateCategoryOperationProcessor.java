package com.tinqin.academy.piim.business.operations.categories;

import com.tinqin.academy.piim.api.category.create.CreateCategoryInput;
import com.tinqin.academy.piim.api.category.create.CreateCategoryOperation;
import com.tinqin.academy.piim.api.category.create.CreateCategoryResult;
import com.tinqin.academy.piim.data.models.Category;
import com.tinqin.academy.piim.data.repositories.CategoryRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class CreateCategoryOperationProcessor implements CreateCategoryOperation {
    private final CategoryRepository categoryRepository;
    private final ConversionService conversionService;

    @Override
    public CreateCategoryResult process(CreateCategoryInput input) {

        Category category = conversionService.convert(input, Category.class);
        if (category == null) {
            throw new InvalidParameterException("Input is empty.");
        }
        if (categoryRepository.existsByName(category.getName()))
            throw new EntityExistsException(String.format("Category with name %s already exists.", input.getName()));

        category = categoryRepository.save(category);
        return conversionService.convert(category, CreateCategoryResult.class);
    }
}
