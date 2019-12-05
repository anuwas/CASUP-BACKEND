package com.ca.supportlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ca.supportlog.domain.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
