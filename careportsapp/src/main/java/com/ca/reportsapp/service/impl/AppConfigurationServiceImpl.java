/**
 * 
 */
package com.ca.reportsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.reportsapp.dao.domain.entity.ApplicationUser;
import com.ca.reportsapp.dao.domain.entity.Applications;
import com.ca.reportsapp.dao.domain.entity.DevSprint;
import com.ca.reportsapp.dao.repository.ApplicationUserRepository;
import com.ca.reportsapp.dao.repository.ApplicationsRepository;
import com.ca.reportsapp.dao.repository.DevSprintRepository;
import com.ca.reportsapp.service.AppConfigurationService;

/**
 * @author Anupam Biswas
 * 2020-04-15 01:46:48.264
 */
@Service
public class AppConfigurationServiceImpl implements AppConfigurationService{
	
	@Autowired
	ApplicationsRepository applicationsRepository;
	
	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	DevSprintRepository devSprintRepository;
	

	@Override
	public List<ApplicationUser> getAllApplicationUserList() {
		return (List<ApplicationUser>) applicationUserRepository.findAll();
	}

	@Override
	public List<Applications> getAllApplicationsList() {
		return (List<Applications>) applicationsRepository.findAll();
	}

	@Override
	public List<DevSprint> getAllDevSprintList() {
		return (List<DevSprint>) devSprintRepository.findAll();
	}

}
