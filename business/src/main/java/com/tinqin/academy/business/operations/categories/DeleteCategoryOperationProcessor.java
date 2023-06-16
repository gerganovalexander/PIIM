package com.tinqin.academy.business.operations.categories;

import com.tinqin.academy.api.category.delete.DeleteCategoryInput;
import com.tinqin.academy.api.category.delete.DeleteCategoryOperation;
import com.tinqin.academy.api.category.delete.DeleteCategoryResult;
import com.tinqin.academy.data.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class DeleteCategoryOperationProcessor implements DeleteCategoryOperation {

    private final CategoryRepository categoryRepository;

    @Override
    public DeleteCategoryResult process(DeleteCategoryInput input) {
        if (input.getId() <= 0) throw new InvalidParameterException("Category id is invalid.");
        if (!categoryRepository.existsById(input.getId()))
            throw new EntityNotFoundException(String.format("Category with id %d does not exist.", input.getId()));

        categoryRepository.deleteById(input.getId());

        return DeleteCategoryResult.builder()
                .success(true)
                .build();
    }
}
