package com.neylandev.delivery.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Category {
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    BOOKS("Books"),
    BEAUTY("Beauty"),
    FOOD("Food"),
    SPORTS("Sports"),
    HOME("Home"),
    TOYS("Toys");

    private final String name;
}

