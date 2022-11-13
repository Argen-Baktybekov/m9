package edu.attractor.kg.m9.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@RequiredArgsConstructor

@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Customer customer;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("price ASC" )
    private List<Item> items;

    @Column (name = "time")
    private LocalDateTime time;

    @Transient
    private double total = 0.0d;
}
