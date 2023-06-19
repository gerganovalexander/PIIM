package com.tinqin.academy.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Table(name = "game_patches")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GamePatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String version;

    private String description;

    @CreationTimestamp
    private LocalDate uploadedAt;

    @ManyToOne
    private Game game;

}
