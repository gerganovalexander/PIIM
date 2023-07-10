package com.tinqin.academy.piim.business.operations.categories;

import com.tinqin.academy.piim.api.category.getbyname.GetByNameCategoryInput;
import com.tinqin.academy.piim.api.category.getbyname.GetByNameCategoryOperation;
import com.tinqin.academy.piim.api.category.getbyname.GetByNameCategoryResult;
import com.tinqin.academy.piim.api.errors.category.GetByNameCategoryError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.Category;
import com.tinqin.academy.piim.data.repositories.CategoryRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetByNameCategoryOperationProcessor implements GetByNameCategoryOperation {

    private final CategoryRepository categoryRepository;

    @Override
    public Either<PiimError, GetByNameCategoryResult> process(GetByNameCategoryInput input) {
        return Try.of(() -> {
                    Category category = categoryRepository
                            .findFirstByName(input.getName())
                            .orElseThrow(() -> new EntityNotFoundException(
                                    String.format("Category with name %s does not exist.", input.getName())));

                    return GetByNameCategoryResult.builder()
                            .id(category.getId())
                            .name(category.getName())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetByNameCategoryError(400, throwable.getMessage()));
    }
}
