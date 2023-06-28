package com.tinqin.academy.piim.api.category.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryInput implements OperationInput {
    private String name;
}
