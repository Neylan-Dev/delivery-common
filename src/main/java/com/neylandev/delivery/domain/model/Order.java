package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @NotNull
    private BigDecimal subtotal;

    @NotNull
    private BigDecimal shipping;

    @NotNull
    private BigDecimal total;

    @NotNull
    private OffsetDateTime orderedDate;
    private OffsetDateTime endDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();

    @Embedded
    private Recipient recipient;

    private OrderStatus orderStatus;
}
