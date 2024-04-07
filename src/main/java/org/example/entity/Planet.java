package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(name = "id")
    @Pattern(regexp = "^[A-Z]+$")
    private String planetId;

    @Column
    @Length(min = 3, max = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> fromPlanetTickets = new HashSet<>();

    @OneToMany(mappedBy = "toPlanetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> toPlanetTickets = new HashSet<>();

    @Override
    public String toString() {
        return "Planet{" +
                "planetId='" + planetId + '\'' +
                ", name='" + name +
                '}';
    }
}
