/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.UserTaskSchedulerActivity;

/**
 * @author Anupam Biswas
 * 2020-04-13 01:25:51.173
 */
@Repository
public interface UserTaskSchedulerActivityRepository extends PagingAndSortingRepository<UserTaskSchedulerActivity, Long>{
	List<UserTaskSchedulerActivity> findByTaskSchedulerId(long taskSchedulerId,Sort sort);
}
