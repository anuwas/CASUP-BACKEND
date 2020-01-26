/**
 * 
 */
package com.ca.reportsapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ca.reportsapp.dao.domain.entity.DevDailyScrum;
import com.ca.reportsapp.dao.repository.DevDailyScrumRepository;

/**
 * @author Anupam Biswas
 * 2020-01-12 01:34:50.519
 */
public interface DevDailyScrumDAO extends DevDailyScrumRepository{
	Page<DevDailyScrum> findAll(Pageable pageable);
}
