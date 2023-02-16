package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.PaymentStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "payments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String paymentType;

    @NotBlank
    private String cardNumber;

    @NotBlank
    private String cardName;

    @NotBlank
    private String expirationDate;

    @NotBlank
    private String cvv;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}

