package com.tinqin.academy.api.game.getall;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllGamesResults implements OperationResult {

    private List<GetAllGamesResult> results;
}
