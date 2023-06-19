package com.tinqin.academy.piim.api.category.delete;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCategoryResult implements OperationResult {
    private Boolean success;
}
