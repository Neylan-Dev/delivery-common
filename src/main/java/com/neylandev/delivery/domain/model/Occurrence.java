package com.neylandev.delivery.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "occurrences")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    private Order order;
    private String description;
    private OffsetDateTime registerDate;
}
