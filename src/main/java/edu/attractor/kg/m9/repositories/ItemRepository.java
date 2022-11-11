package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
