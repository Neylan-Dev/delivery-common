package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.StatusEmail;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "emails")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String clientEmail;
    private String subject;
    private String body;
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
    private LocalDateTime sendDateEmail;

}
