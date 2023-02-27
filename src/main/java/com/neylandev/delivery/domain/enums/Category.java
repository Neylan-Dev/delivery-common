package com.neylandev.delivery.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum Category {
    ELECTRONICS("Electronics", "Eletronicos"),
    CLOTHING("Clothing", "Vestuário"),
    BOOKS("Books","Livros"),
    BEAUTY("Beauty", "Beleza"),
    FOOD("Food", "Comida"),
    SPORTS("Sports", "Esportes"),
    HOME("Home", "Casa"),
    TOYS("Toys", "Brinquedos");

    private final String name;

    private final String portugueseName;

    private final List<String> portugueseCategories = Stream.of(Category.values()).map(Category::getPortugueseName).collect(Collectors.toList());
}

