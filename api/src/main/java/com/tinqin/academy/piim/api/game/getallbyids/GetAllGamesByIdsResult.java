package com.tinqin.academy.piim.api.game.getallbyids;

import com.tinqin.academy.piim.api.entityoutputmodels.GameOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllGamesByIdsResult implements OperationResult {

    Integer page;
    Integer limit;
    Long totalItems;
    List<GameOutput> games;
}
