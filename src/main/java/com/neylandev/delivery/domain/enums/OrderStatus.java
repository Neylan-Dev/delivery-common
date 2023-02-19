package com.neylandev.delivery.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    PENDING("Pending"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String name;

    private static final List<OrderStatus> canCancel = List.of(PENDING, PROCESSING, SHIPPED);

    public static boolean canCancel(OrderStatus orderStatus) {
        return canCancel.contains(orderStatus);
    }
}

