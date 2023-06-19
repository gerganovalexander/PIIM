package com.tinqin.academy.piim.api.gamepatch.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetGamePatchByIdInput implements OperationInput {

    private Long id;
}
