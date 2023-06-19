package com.tinqin.academy.piim.api.user.getall;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResults implements OperationResult {
    private List<GetAllUsersResult> results;
}
