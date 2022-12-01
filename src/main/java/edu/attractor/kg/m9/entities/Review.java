package edu.attractor.kg.m9.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
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

    public Review(String comment, String username) {
        this.comment = comment;
        this.username = username;
        this.time = Timestamp.valueOf(LocalDateTime.now());
    }
}
