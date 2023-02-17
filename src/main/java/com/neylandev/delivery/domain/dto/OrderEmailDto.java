package com.neylandev.delivery.domain.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEmailDto {

    private String clientEmail;
    private String subject;
    private String body;

}
