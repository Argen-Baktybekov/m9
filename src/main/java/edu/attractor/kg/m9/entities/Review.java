package edu.attractor.kg.m9.entities;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "username")
    private String username;

    @Column(name = "time")
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public Timestamp getTime() {
        return time;
    }

    public Long getItem() {
        return item.getId();
    }

    public Review(String comment, String username, Item item) {
        this.comment = comment;
        this.username = username;
        this.time = Timestamp.valueOf(LocalDateTime.now());
        this.item = item;
    }
}
