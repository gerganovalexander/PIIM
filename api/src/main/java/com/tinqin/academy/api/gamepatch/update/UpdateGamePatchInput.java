package com.tinqin.academy.api.gamepatch.update;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGamePatchInput implements OperationInput {

    private Long id;
    private String description;
}
