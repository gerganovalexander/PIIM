package com.tinqin.academy.piim.api.game.getallbyids;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllGamesByIdsInput implements OperationInput {
    @NotNull
    private List<Long> ids;

    @NotNull
    private Integer page;

    @NotNull
    private Integer size;
}
