package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.Role;
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
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
