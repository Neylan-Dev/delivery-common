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
public class Address {

    @Column(name = "address_street")
    private String street;
    @Column(name = "address_number")
    private String number;
    @Column(name = "address_complement")
    private String complement;
    @Column(name = "address_neighborhood")
    private String neighborhood;
    @Column(name = "address_zip_code")
    private String zipCode;
    @Column(name = "address_city")
    private String city;
    @Column(name = "address_state")
    @Enumerated(EnumType.STRING)
    private BrazilianState state;
    @Column(name = "address_country")
    private String country;
}
