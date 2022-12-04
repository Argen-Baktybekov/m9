package edu.attractor.kg.m9.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "items_with_amounts")
public class ItemWA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @Column(name = "number")
    private Integer number ;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public ItemWA(Item item, Basket basket) {
        this.item = item;
        this.number = 1;
        this.basket = basket;
    }

}
