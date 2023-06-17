package com.tinqin.academy.api.review.update;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateReviewInput implements OperationInput {
    private Long id;
    private String text;
}
