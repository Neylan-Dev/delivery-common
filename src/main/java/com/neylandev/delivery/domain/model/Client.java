package com.neylandev.delivery.domain.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "clients")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @EqualsAndHashCode.Include
    private String email;
    @EqualsAndHashCode.Include
    private String telephone;
    @Embedded
    private Address address;
    @Embedded
    private Account account;

}
