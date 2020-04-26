/**
 * 
 */
package com.ca.reportsapp.service.impl;

import java.util.ArrayList;
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
	public List<String> getAllApplicationsList() {
		List<Applications> applications = (List<Applications>) applicationsRepository.findAll();
		List<String> applicationList = new ArrayList<>();
		for(Applications apsObj : applications) {
			applicationList.add(apsObj.getApplicationName());
		}
		return applicationList;
	}

	@Override
	public List<String> getAllDevSprintList() {
		List<DevSprint> devSprintsObjList =  (List<DevSprint>) devSprintRepository.findAll();
		List<String> devSprintsList = new ArrayList<>();
		for(DevSprint devSprintObj : devSprintsObjList) {
			devSprintsList.add(devSprintObj.getSprintName());
		}
		return devSprintsList;
	}

}
