package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.StockMovementType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "stock_movements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @NotNull
    private int quantity;

    @NotNull
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private StockMovementType type;

}

