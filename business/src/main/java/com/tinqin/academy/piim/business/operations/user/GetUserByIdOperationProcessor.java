package com.tinqin.academy.piim.business.operations.user;

import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdInput;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdOperation;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdResult;
import com.tinqin.academy.piim.data.models.User;
import com.tinqin.academy.piim.data.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetUserByIdOperationProcessor implements GetUserByIdOperation {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Override
    public GetUserByIdResult process(GetUserByIdInput userInput) {
        if (!userRepository.existsById(userInput.getId())) {
            throw new EntityNotFoundException("User not found");
        }
        User user = userRepository.findUserById(userInput.getId());

        return conversionService.convert(user, GetUserByIdResult.class);
    }
}
