package com.tinqin.academy.piim.api.game.getallbyids;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllGamesByIdsInput implements OperationInput {
    private List<Long> ids;
    private Integer page;
    private Integer size;
}
