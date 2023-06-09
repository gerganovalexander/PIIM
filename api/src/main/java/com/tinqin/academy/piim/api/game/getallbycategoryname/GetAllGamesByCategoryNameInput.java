package com.tinqin.academy.piim.api.game.getallbycategoryname;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllGamesByCategoryNameInput implements OperationInput {
    @NotNull(message = "Category name is null")
    @Pattern(regexp = "^\\w+$", message = "Invalid category name")
    private String categoryName;

    @NotNull(message = "Page is null")
    @PositiveOrZero(message = "Page is negative")
    private Integer page;

    @NotNull(message = "Size is null")
    @Min(value = 1, message = "Minimum page size is 1")
    @Max(value = 100, message = "Maximum page size is 100")
    private Integer size;
}
