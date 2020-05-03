/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.Applications;

/**
 * @author Anupam Biswas
 * 2020-04-15 01:34:33.175
 */
@Repository
public interface ApplicationsRepository extends PagingAndSortingRepository<Applications, Long>{

}
