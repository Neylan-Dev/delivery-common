package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDateTime orderedDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();

    @Embedded
    private Recipient recipient;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Boolean delivered;
}
