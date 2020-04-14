/**
 * 
 */
package com.ca.reportsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ca.reportsapp.dao.domain.entity.ApplicationUser;
import com.ca.reportsapp.dao.domain.entity.Applications;
import com.ca.reportsapp.dao.domain.entity.DevSprint;
import com.ca.reportsapp.dao.domain.entity.UserTaskSchedulerActivity;
import com.ca.reportsapp.service.AppConfigurationService;

/**
 * @author Anupam Biswas
 * 2020-04-15 01:44:57.241
 */
@RestController
@CrossOrigin(origins="${rest.client.origin}")
@RequestMapping(value="/api/config")
public class AppConfigController {
	
	@Autowired
	AppConfigurationService appConfigurationService;
	
	
	@GetMapping("/all-app-user-list")
	public List<ApplicationUser> getAllApplicationUserList() {
		 return appConfigurationService.getAllApplicationUserList();
	}
	
	@GetMapping("/all-applications")
	public List<Applications> getAllApplicationsList() {
		 return appConfigurationService.getAllApplicationsList();
	}
	
	@GetMapping("/all-dev-sprints")
	public List<DevSprint> getAllDevSprintsList() {
		 return appConfigurationService.getAllDevSprintList();
	}
	
	

}
