package com.tinqin.academy.api.entityoutputmodels;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GamePatchOutput {
    private Long id;
    private String version;
    private String description;
    private LocalDate uploadedAt;
    private GameOutput game;
}
