package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Length(min = 3, max = 200)
    private String name;

    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
