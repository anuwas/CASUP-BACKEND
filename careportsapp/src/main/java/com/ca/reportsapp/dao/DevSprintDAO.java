/**
 * 
 */
package com.ca.reportsapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.DevSprint;
import com.ca.reportsapp.dao.repository.DevSprintRepository;

/**
 * @author Anupam Biswas
 * 2020-01-12 01:23:32.591
 */
@Repository
public interface DevSprintDAO extends DevSprintRepository {
	Page<DevSprint> findAll(Pageable pageable);
}
