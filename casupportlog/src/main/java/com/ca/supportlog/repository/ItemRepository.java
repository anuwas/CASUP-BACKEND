package com.ca.supportlog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.supportlog.domain.entity.Item;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>{
	Page<Item> findAll(Pageable pageable);
}
