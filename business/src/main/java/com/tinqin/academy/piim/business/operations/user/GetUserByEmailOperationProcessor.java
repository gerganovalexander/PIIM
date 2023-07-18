package com.tinqin.academy.piim.business.operations.user;

import com.tinqin.academy.piim.api.errors.user.GetUserByEmailError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.user.getbyusername.GetUserByEmailInput;
import com.tinqin.academy.piim.api.user.getbyusername.GetUserByEmailOperation;
import com.tinqin.academy.piim.api.user.getbyusername.GetUserByEmailResult;
import com.tinqin.academy.piim.data.models.User;
import com.tinqin.academy.piim.data.repositories.UserRepository;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserByEmailOperationProcessor implements GetUserByEmailOperation {
    private final UserRepository userRepository;

    @Override
    public Either<PiimError, GetUserByEmailResult> process(GetUserByEmailInput input) {
        Optional<User> user = userRepository.findUserByEmail(input.getEmail());
        if (user.isPresent()) {
            User presentUser = user.get();
            return Either.right(GetUserByEmailResult.builder()
                    .id(presentUser.getId())
                    .email(presentUser.getEmail())
                    .firstName(presentUser.getFirstName())
                    .lastName(presentUser.getLastName())
                    .build());
        }
        return Either.left(new GetUserByEmailError(400, "lesh brat"));
    }
}
