package com.cg.repositories;

import com.cg.repositories.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByProductIdOrderByCreatedAt(long productId);

    List<Item> findAllByProductIdAndAvailableGreaterThanOrderByCreatedAt(long productId, int available);
}
