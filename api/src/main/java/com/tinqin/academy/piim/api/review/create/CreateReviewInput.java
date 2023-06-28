package com.tinqin.academy.piim.api.review.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewInput implements OperationInput {

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    @Min(value = 1, message = "Min score is 1")
    @Max(value = 5, message = "Max score is 5")
    private Integer score;

    @NotNull
    @NotBlank
    private String text;

    @NotNull
    @Positive
    private Long gameId;
}
