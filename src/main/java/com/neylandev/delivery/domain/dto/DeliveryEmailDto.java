package com.neylandev.delivery.domain.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEmailDto {

    private String clientEmail;
    private String subject;
    private String body;

}
