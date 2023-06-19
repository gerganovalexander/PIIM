package com.tinqin.academy.piim.api.category.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCategoryInput implements OperationInput {
    private Long id;
}
