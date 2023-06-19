package com.tinqin.academy.api.category.delete;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCategoryResult implements OperationResult {
    private Boolean success;
}
