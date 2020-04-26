/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.DevDailyScrumStatus;

/**
 * @author Anupam Biswas
 * 2020-04-22 01:30:06.164
 */
@Repository
public interface DevDailyScrumStatusRepository extends PagingAndSortingRepository<DevDailyScrumStatus, Long>{
	List<DevDailyScrumStatus> findByDevItem(String devItem,Sort sort);
}
