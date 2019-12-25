package com.ca.reportsapp.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.domain.entity.SupportItem;

/**
 * @author Anupam Biswas
 * 2019-12-25 19:24:29.327
 */

@Repository
public interface SupportItemRepository extends PagingAndSortingRepository<SupportItem, Long>{
	
	Page<SupportItem> findAll(Pageable pageable);
	List<SupportItem> findByitemStatusNotIn(List<String> names);
	Page<SupportItem> findByitemNumber(Pageable pageable,long itemNumber);

}
