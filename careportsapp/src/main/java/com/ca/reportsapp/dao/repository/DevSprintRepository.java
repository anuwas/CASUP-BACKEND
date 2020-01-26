/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.DevSprint;

/**
 * @author Anupam Biswas
 * 2020-01-12 01:22:40.186
 */
@Repository
public interface DevSprintRepository extends PagingAndSortingRepository<DevSprint, Long>{

}
