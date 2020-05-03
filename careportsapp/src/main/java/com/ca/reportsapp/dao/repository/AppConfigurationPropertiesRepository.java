/**
 * 
 */
package com.ca.reportsapp.dao.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ca.reportsapp.dao.domain.entity.AppConfigurationProperties;

/**
 * @author Anupam Biswas
 * 2020-04-28 00:48:11.105
 */
@Repository
public interface AppConfigurationPropertiesRepository  extends PagingAndSortingRepository<AppConfigurationProperties, Long>{
	List<AppConfigurationProperties> findByConfigName(String configName);
}
