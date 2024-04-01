package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column
    @Pattern(regexp = "^[A-Z]+$")
    private String id;

    @Column
    @Length(min = 3, max = 500)
    private String name;
}
