/**
 * 
 */
package com.ca.reportsapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ca.reportsapp.dao.domain.entity.ApplicationUser;

/**
 * @author Anupam Biswas
 * 2020-04-15 01:36:50.661
 */
@Service
public interface AppConfigurationService {
	
	public List<ApplicationUser> getAllApplicationUserList();
	public List<String> getAllApplicationsList();
	public List<String> getAllDevSprintList();

}
