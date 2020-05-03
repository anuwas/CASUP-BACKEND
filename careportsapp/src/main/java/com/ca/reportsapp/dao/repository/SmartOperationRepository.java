/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ca.reportsapp.dao.domain.entity.SmartOperation;

/**
 * @author Anupam Biswas
 * 2020-05-02 21:36:16.404
 */
public interface SmartOperationRepository extends PagingAndSortingRepository<SmartOperation, Long>{
	public List<SmartOperation> findByComment(String comment);
}
