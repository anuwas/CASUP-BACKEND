/**
 * 
 */
package com.ca.reportsapp.dao.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.SupportItemActivity;



/**
 * @author Anupam Biswas
 * 2019-12-25 21:47:22.182
 */
@Repository
public interface SupportItemActivityRepository extends PagingAndSortingRepository<SupportItemActivity, Long>{
	
}
