package com.tinqin.academy.piim.api.review.getreviewsbygameid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetReviewsByGameIdInput implements OperationInput {
    @NotNull
    private Long id;
}
