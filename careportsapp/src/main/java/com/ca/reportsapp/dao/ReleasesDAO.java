/**
 * 
 */
package com.ca.reportsapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.Releases;
import com.ca.reportsapp.dao.repository.ReleaseRepository;

/**
 * @author Anupam Biswas
 * 2020-03-15 03:19:32.724
 */
@Repository
public interface ReleasesDAO extends ReleaseRepository {
	Page<Releases> findAll(Pageable pageable);
}
