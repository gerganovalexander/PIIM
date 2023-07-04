package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameInput;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameOperation;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameResult;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistsByIdGameOperationProcessor implements ExistsByIdGameOperation {
    private final GameRepository gameRepository;
    @Override
    public ExistsByIdGameResult process(ExistsByIdGameInput input) {
        boolean doesExist = gameRepository.existsById(input.getId());
        return ExistsByIdGameResult.builder()
                .doesExist(doesExist).build();

    }
}
