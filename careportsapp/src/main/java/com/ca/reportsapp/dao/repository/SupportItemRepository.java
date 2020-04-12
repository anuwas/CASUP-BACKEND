package com.ca.reportsapp.dao.repository;



import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.SupportItem;



/**
 * @author Anupam Biswas
 * 2019-12-25 19:24:29.327
 */

@Repository
public interface SupportItemRepository extends PagingAndSortingRepository<SupportItem, Long>,JpaSpecificationExecutor{
	
	

}
