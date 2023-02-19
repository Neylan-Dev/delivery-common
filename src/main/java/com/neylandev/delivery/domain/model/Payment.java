package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.PaymentStatus;
import com.neylandev.delivery.domain.enums.PaymentType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @EqualsAndHashCode.Include
    private Order order;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @EqualsAndHashCode.Include
    private PaymentType paymentType;

    private String cardNumber;

    private String cardName;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;

    private String cvv;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate paymentDate;

    private String barCode;

    private String pixKey;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean flagPaid = false;
}

