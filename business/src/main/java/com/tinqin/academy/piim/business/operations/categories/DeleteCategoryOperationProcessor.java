package com.tinqin.academy.piim.business.operations.categories;

import com.tinqin.academy.piim.api.category.delete.DeleteCategoryInput;
import com.tinqin.academy.piim.api.category.delete.DeleteCategoryOperation;
import com.tinqin.academy.piim.api.category.delete.DeleteCategoryResult;
import com.tinqin.academy.piim.api.errors.category.DeleteCategoryError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.repositories.CategoryRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class DeleteCategoryOperationProcessor implements DeleteCategoryOperation {

    private final CategoryRepository categoryRepository;

    @Override
    public Either<PiimError, DeleteCategoryResult> process(DeleteCategoryInput input) {
        return Try.of(() -> {
                    if (input.getId() <= 0) throw new InvalidParameterException("Category id is invalid.");
                    if (!categoryRepository.existsById(input.getId()))
                        throw new EntityNotFoundException(
                                String.format("Category with id %d does not exist.", input.getId()));

                    categoryRepository.deleteById(input.getId());

                    return DeleteCategoryResult.builder().success(true).build();
                })
                .toEither()
                .mapLeft(throwable -> new DeleteCategoryError(400, throwable.getMessage()));
    }
}
