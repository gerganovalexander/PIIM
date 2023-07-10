package com.tinqin.academy.piim.business.operations.categories;

import com.tinqin.academy.piim.api.category.update.UpdateCategoryInput;
import com.tinqin.academy.piim.api.category.update.UpdateCategoryOperation;
import com.tinqin.academy.piim.api.category.update.UpdateCategoryResult;
import com.tinqin.academy.piim.api.errors.category.UpdateCategoryError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.Category;
import com.tinqin.academy.piim.data.repositories.CategoryRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
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
    public Either<PiimError, UpdateCategoryResult> process(UpdateCategoryInput input) {
        return Try.of(() -> {
                    if (input.getId() <= 0) throw new InvalidParameterException("Category id is invalid.");
                    if (!categoryRepository.existsById(input.getId()))
                        throw new EntityNotFoundException(
                                String.format("Category with id %d does not exist.", input.getId()));
                    if (categoryRepository.existsByName(input.getName()))
                        throw new EntityExistsException(
                                String.format("Category with name %s already exists.", input.getName()));

                    Category category = Category.builder()
                            .id(input.getId())
                            .name(input.getName())
                            .build();

                    categoryRepository.save(category);

                    return conversionService.convert(category, UpdateCategoryResult.class);
                })
                .toEither()
                .mapLeft(throwable -> new UpdateCategoryError(400, throwable.getMessage()));
    }
}
