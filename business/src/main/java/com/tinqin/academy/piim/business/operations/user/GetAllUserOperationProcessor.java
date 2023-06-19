package com.tinqin.academy.piim.business.operations.user;

import com.tinqin.academy.piim.api.user.getall.GetAllUsersInput;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersOperation;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersResult;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersResults;
import com.tinqin.academy.piim.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllUserOperationProcessor implements GetAllUsersOperation {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Override
    public GetAllUsersResults process(GetAllUsersInput input) {
        List<GetAllUsersResult> results = userRepository.findAll().stream()
                .map(user -> conversionService.convert(user, GetAllUsersResult.class))
                .collect(Collectors.toList());

        return new GetAllUsersResults(results);
    }


}

