package com.tinqin.academy.api.category.update;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCategoryInput implements OperationInput {
    private Long id;
    private String name;
}
