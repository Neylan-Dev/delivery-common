package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Column(name = "account_agency")
    private String agency;
    @Column(name = "account_number")
    private String number;
    @Column(name = "account_digit")
    private String digit;
    @Column(name = "account_type")
    private AccountType accountType;
}
