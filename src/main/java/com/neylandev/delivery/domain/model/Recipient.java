package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.BrazilianState;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {

    @Column(name = "recipient_name")
    private String name;
    @Column(name = "recipient_street")
    private String street;
    @Column(name = "recipient_number")
    private String number;
    @Column(name = "recipient_complement")
    private String complement;
    @Column(name = "recipient_neighborhood")
    private String neighborhood;
    @Column(name = "recipient_zip_code")
    private String zipCode;
    @Column(name = "recipient_city")
    private String city;
    @Column(name = "recipient_state")
    @Enumerated(EnumType.STRING)
    private BrazilianState state;
    @Column(name = "recipient_country")
    private String country;
}
