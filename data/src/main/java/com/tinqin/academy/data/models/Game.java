package com.tinqin.academy.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany
    private Set<Category> category;

    private String avgReviewDescription;

    private LocalDateTime releaseDate;

    private String publisher;

    @ManyToOne
    private SystemRequirements systemRequirements;

    @OneToMany(mappedBy = "game")
    private Set<GamePatch> listOfPatches;

}
