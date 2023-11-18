package com.neylandev.delivery.domain.model;

import com.neylandev.delivery.domain.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @EqualsAndHashCode.Include
    private String name;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @EqualsAndHashCode.Include
    private Category category;

    @NotBlank
    private String imageUrl;
}

