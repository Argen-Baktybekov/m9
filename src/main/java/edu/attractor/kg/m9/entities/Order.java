package edu.attractor.kg.m9.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "total")
    private Double total;

    public Order(String email, ItemWA items) {
        this.email = email;
        this.item = items.getItem();
        this.price = items.getItem().getPrice();
        this.amount = items.getNumber();
        this.time = Timestamp.valueOf(LocalDateTime.now());
        this.total = this.price * this.amount;
    }
}
