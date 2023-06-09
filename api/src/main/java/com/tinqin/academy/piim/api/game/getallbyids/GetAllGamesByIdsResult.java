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

    private Integer page;
    private Integer limit;
    private Long totalItems;
    private List<GameOutput> games;
}
