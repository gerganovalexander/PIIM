package com.tinqin.academy.piim.api.systemrequirements.delete;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSystemRequirementsResult implements OperationResult {
    Boolean success;
}
