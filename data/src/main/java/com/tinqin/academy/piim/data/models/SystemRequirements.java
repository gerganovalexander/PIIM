package com.tinqin.academy.piim.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Entity
@Table(name = "system_requirements")
@AllArgsConstructor
public class SystemRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operatingSystem;
    private String cpu;
    private String gpu;
    private Integer ram;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemRequirements that = (SystemRequirements) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
