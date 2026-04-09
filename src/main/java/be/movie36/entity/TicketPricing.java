package be.movie36.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket_pricing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketPricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double price;

    private String ageGroup;

    @Column(columnDefinition = "TEXT")
    private String rules;
}
