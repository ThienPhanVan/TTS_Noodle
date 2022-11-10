package com.cg.repositories;

import com.cg.repositories.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByProductIdOrderByCreatedAt(long productId);
}
