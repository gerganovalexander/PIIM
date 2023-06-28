package com.tinqin.academy.piim.api.user.delete;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserResult implements OperationResult {
    private Boolean success;
}
