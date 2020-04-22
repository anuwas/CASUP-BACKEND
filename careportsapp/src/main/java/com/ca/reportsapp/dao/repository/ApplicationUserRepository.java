/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.ApplicationUser;
/**
 * @author Anupam Biswas
 * 2020-04-15 01:35:42.065
 */
@Repository
public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long>{

}
