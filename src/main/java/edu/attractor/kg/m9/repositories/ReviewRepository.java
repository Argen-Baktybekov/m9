package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByItem_Id(Long itemId);
}
