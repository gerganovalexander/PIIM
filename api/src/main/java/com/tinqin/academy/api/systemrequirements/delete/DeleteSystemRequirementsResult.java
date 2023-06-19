package com.tinqin.academy.api.systemrequirements.delete;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSystemRequirementsResult implements OperationResult {
    Boolean success;
}
