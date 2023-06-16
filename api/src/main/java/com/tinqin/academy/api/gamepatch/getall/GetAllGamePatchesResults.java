package com.tinqin.academy.api.gamepatch.getall;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllGamePatchesResults implements OperationResult {
    List<GetAllGamePatchesResult> results;
}
