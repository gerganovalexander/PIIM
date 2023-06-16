package com.tinqin.academy.api.category.getbyname;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameCategoryInput implements OperationInput {
    private String name;
}
