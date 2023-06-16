package com.tinqin.academy.api.entityoutputmodels;

import com.tinqin.academy.api.category.create.CreateCategoryResult;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameOutput {
    private Long id;

    private String name;

    //    private Set<CategoryOutput> category;
    private Set<CreateCategoryResult> category;

    private String avgReviewDescription;

    private LocalDateTime releaseDate;

    private String publisher;

    private SystemRequirementsOutput systemRequirements;
}
