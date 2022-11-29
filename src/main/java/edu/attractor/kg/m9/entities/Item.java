package edu.attractor.kg.m9.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "image")
    @NotNull
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "number", columnDefinition = "integer default 1")
    private Integer number;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "in_stock", columnDefinition = "boolean default true")
    private boolean inStock;

}
