/**
 * 
 */
package com.ca.reportsapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.domain.entity.SupportItemActivity;

/**
 * @author Anupam Biswas
 * 2019-12-25 21:47:22.182
 */
@Repository
public interface SupportItemActivityRepository extends PagingAndSortingRepository<SupportItemActivity, Long>{
	List<SupportItemActivity> findAllByitemId(long itemId,Sort sort);
}
