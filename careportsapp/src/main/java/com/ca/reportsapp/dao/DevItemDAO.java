/**
 * 
 */
package com.ca.reportsapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.DevItem;
import com.ca.reportsapp.dao.repository.DevItemRepository;

/**
 * @author Anupam Biswas
 * 2020-01-12 00:56:14.964
 */
@Repository
public interface DevItemDAO extends DevItemRepository{
	Page<DevItem> findAll(Pageable pageable);
	List<DevItem> findByItemNumber(String parentIteam);
	List<DevItem> findByItemSprintName(String currentSprint);
}
