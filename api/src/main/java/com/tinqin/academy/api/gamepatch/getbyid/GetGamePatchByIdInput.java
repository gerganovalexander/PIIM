package com.tinqin.academy.api.gamepatch.getbyid;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetGamePatchByIdInput implements OperationInput {

    private Long id;
}
