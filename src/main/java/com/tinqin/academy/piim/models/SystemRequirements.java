package com.tinqin.academy.piim.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "system_requirements")
public class SystemRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemRequirementsId;

    private String operatingSystem;
    private String cpu;
    private String gpu;
    private Integer ram;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemRequirements that = (SystemRequirements) o;
        return Objects.equals(systemRequirementsId, that.systemRequirementsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemRequirementsId);
    }
}
