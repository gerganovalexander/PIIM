package com.tinqin.academy.piim.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany
//    @JoinColumn(name = "id")
    private Set<Category> category;

    private LocalDateTime releaseDate;

    private String publisher;

    @ManyToOne
    private SystemRequirements systemRequirements;

}
