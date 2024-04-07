package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer ticketId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client clientId;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanetId;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanetId;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", createdAt=" + createdAt +
                ", clientId=" + clientId +
                ", fromPlanetId=" + fromPlanetId +
                ", toPlanetId=" + toPlanetId +
                '}';
    }
}
