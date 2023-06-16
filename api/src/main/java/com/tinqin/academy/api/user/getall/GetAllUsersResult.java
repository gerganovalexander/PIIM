package com.tinqin.academy.api.user.getall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResult {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
