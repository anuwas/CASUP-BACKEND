/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.DevDailyScrum;

/**
 * @author Anupam Biswas
 * 2020-01-12 01:33:05.737
 */
@Repository
public interface DevDailyScrumRepository extends PagingAndSortingRepository<DevDailyScrum, Long>{

}
