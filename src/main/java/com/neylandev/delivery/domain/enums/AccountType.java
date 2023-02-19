package com.neylandev.delivery.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountType {

    SAVINGS("Savings"),
    CURRENT("Current");

    private final String nome;

}
