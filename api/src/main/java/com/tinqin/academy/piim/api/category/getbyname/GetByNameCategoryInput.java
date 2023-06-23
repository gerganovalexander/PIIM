package com.tinqin.academy.piim.api.category.getbyname;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameCategoryInput implements OperationInput {
    @NotNull(message = "Category name is null")
    @Pattern(regexp = "^\\w+$", message = "Invalid category name")
    private String name;
}
