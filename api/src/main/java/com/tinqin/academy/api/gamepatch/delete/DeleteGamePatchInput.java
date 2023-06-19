package com.tinqin.academy.api.gamepatch.delete;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteGamePatchInput implements OperationInput {

    private Long id;
}
