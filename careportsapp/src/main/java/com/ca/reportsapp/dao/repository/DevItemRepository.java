/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.DevItem;

/**
 * @author Anupam Biswas
 * 2020-01-12 00:53:58.697
 */
@Repository
public interface DevItemRepository extends PagingAndSortingRepository<DevItem, Long>,JpaSpecificationExecutor<DevItem>{

}
