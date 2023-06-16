package com.tinqin.academy.api.systemrequirements.getbyid;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetSystemRequirementsByIdInput implements OperationInput {

    Long id;
}
