package com.tinqin.academy.piim.business.operations.user;

import com.tinqin.academy.piim.api.errors.user.DeleteUserError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.user.delete.DeleteUserInput;
import com.tinqin.academy.piim.api.user.delete.DeleteUserOperation;
import com.tinqin.academy.piim.api.user.delete.DeleteUserResult;
import com.tinqin.academy.piim.data.repositories.UserRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteUserOperationProcessor implements DeleteUserOperation {
    private final UserRepository userRepository;

    @Override
    public Either<PiimError, DeleteUserResult> process(DeleteUserInput userInput) {
        return Try.of(() -> {
                    if (!userRepository.existsById(userInput.getId())) {
                        throw new EntityNotFoundException("User not found");
                    }
                    userRepository.deleteById(userInput.getId());
                    return new DeleteUserResult(true);
                })
                .toEither()
                .mapLeft(throwable -> new DeleteUserError(400, throwable.getMessage()));
    }
}
