package com.tinqin.academy.api.category.getbyid;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdCategoryInput implements OperationInput {
    private Long id;
}
