/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.Releases;

/**
 * @author Anupam Biswas
 * 2020-03-15 03:06:10.066
 */

@Repository
public interface ReleaseRepository extends PagingAndSortingRepository<Releases, Long>{

}
