package com.tinqin.academy.api.category.delete;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCategoryInput implements OperationInput {
    private Long id;
}
