package com.tinqin.academy.business.operations.user;

import com.tinqin.academy.api.user.delete.DeleteUserInput;
import com.tinqin.academy.api.user.delete.DeleteUserOperation;
import com.tinqin.academy.api.user.delete.DeleteUserResult;
import com.tinqin.academy.data.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteUserOperationProcessor implements DeleteUserOperation {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Override
    public DeleteUserResult process(DeleteUserInput userInput) {
        if (!userRepository.existsById(userInput.getId())) {
            throw new EntityNotFoundException("User not found");
        }
        userRepository.deleteById(userInput.getId());
        return new DeleteUserResult(true);
    }
}
