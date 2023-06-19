package com.tinqin.academy.piim.api.gamepatch.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteGamePatchInput implements OperationInput {

    private Long id;
}
