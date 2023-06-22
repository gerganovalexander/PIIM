package com.tinqin.academy.piim.business.operations.user;

import com.tinqin.academy.piim.api.user.delete.DeleteUserInput;
import com.tinqin.academy.piim.api.user.delete.DeleteUserOperation;
import com.tinqin.academy.piim.api.user.delete.DeleteUserResult;
import com.tinqin.academy.piim.data.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteUserOperationProcessor implements DeleteUserOperation {
    private final UserRepository userRepository;

    @Override
    public DeleteUserResult process(DeleteUserInput userInput) {
        if (!userRepository.existsById(userInput.getId())) {
            throw new EntityNotFoundException("User not found");
        }
        userRepository.deleteById(userInput.getId());
        return new DeleteUserResult(true);
    }
}
