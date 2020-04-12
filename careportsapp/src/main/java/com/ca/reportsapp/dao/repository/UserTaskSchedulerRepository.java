/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.Releases;
import com.ca.reportsapp.dao.domain.entity.UserTaskScheduler;

/**
 * @author Anupam Biswas
 * 2020-04-10 21:51:05.181
 */
@Repository
public interface UserTaskSchedulerRepository extends PagingAndSortingRepository<UserTaskScheduler,Long>{
	Page<UserTaskScheduler> findAll(Pageable pageable);
}
