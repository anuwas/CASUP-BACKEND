/**
 * 
 */
package com.ca.reportsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ca.reportsapp.dao.domain.entity.UserTaskScheduler;
import com.ca.reportsapp.service.UserTaskSchedulerService;

/**
 * @author Anupam Biswas
 * 2020-04-10 22:15:14.551
 */
@RestController
@CrossOrigin(origins="${rest.client.origin}")
@RequestMapping(value="/api/scheduled-tasks")
public class UserTaskController {
	
	@Autowired
	UserTaskSchedulerService userTaskSchedulerService;

	@GetMapping("/all-scheduled-task-list/{page}/{taskparam}")
	public Page<UserTaskScheduler> retriveScheduledTask(@PathVariable int page,@PathVariable String taskparam) {
		 return userTaskSchedulerService.getUserTaskByRequest(taskparam, page);
	}
	
	@PostMapping("/save-scheduled-task")
	public ResponseEntity<Object> createScheduledTask(@RequestBody UserTaskScheduler userTaskScheduler,UriComponentsBuilder builder) {
		UserTaskScheduler savedItem = userTaskSchedulerService.saveTask(userTaskScheduler);

		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/view-scheduled-task/{taskSchedulerId}").buildAndExpand(savedItem.getTaskSchedulerId()).toUri());
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);

	}
	
	@PutMapping("/update-scheduled-task/{taskSchedulerId}")
	public ResponseEntity<Object> updateItem(@RequestBody UserTaskScheduler item, @PathVariable long taskSchedulerId) {
		
		UserTaskScheduler itemOptional = userTaskSchedulerService.getTaskByID(taskSchedulerId);

		if (itemOptional==null)	return ResponseEntity.notFound().build();

		item.setTaskSchedulerId(taskSchedulerId);
		
		userTaskSchedulerService.saveTask(item);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete-scheduled-task/{taskSchedulerId}")
	public void deleteStudent(@PathVariable long taskSchedulerId) {
		userTaskSchedulerService.deleteTaskById(taskSchedulerId);
	}
	
	@GetMapping("/view-scheduled-task/{taskSchedulerId}")
	public UserTaskScheduler retrieveItem(@PathVariable long taskSchedulerId) {
		return userTaskSchedulerService.getTaskByID(taskSchedulerId);
	}
	
}
