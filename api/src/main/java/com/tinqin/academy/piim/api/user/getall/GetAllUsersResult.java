package com.tinqin.academy.piim.api.user.getall;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResult {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
