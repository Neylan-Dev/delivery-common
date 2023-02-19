package com.neylandev.delivery.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    REFUNDED("Refunded");

    private final String name;

    private static final List<PaymentStatus> canCancel = List.of(PENDING, FAILED);

    public static boolean canCancel(PaymentStatus paymentStatus) {
        return canCancel.contains(paymentStatus);
    }
}

