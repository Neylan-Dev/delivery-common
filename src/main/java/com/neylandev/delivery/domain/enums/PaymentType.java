package com.neylandev.delivery.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentType {
    CREDIT_CARD,
    DEBIT_CARD,
    BANK_BILL,
    PIX
}
