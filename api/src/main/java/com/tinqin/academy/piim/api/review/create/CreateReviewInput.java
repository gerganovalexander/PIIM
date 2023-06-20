package com.tinqin.academy.piim.api.review.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewInput implements OperationInput {

    @Positive
    private Long userId;

    @Min(value = 1, message = "Min score is 1")
    @Max(value = 5, message = "Max score is 5")
    private Integer score;

    @NotBlank
    private String text;

    @Positive
    private Long gameId;

}
