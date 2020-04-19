/**
 * 
 */
package com.ca.reportsapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ca.reportsapp.dao.domain.entity.UserTaskScheduler;
import com.ca.reportsapp.dao.domain.entity.UserTaskSchedulerActivity;
import com.ca.reportsapp.dao.repository.UserTaskSchedulerActivityRepository;
import com.ca.reportsapp.dao.repository.UserTaskSchedulerRepository;
import com.ca.reportsapp.dto.UserTaskSchedulerRequest;
import com.ca.reportsapp.service.UserTaskSchedulerService;
import com.ca.reportsapp.service.helper.UserTaskSchedulerServiceHelper;
import com.google.gson.Gson;

/**
 * @author Anupam Biswas
 * 2020-04-10 22:11:59.334
 */
@Service
public class UserTaskSchedulerServiceImpl implements UserTaskSchedulerService{
	
	@Autowired
	Gson gson;
	
	@Autowired
	UserTaskSchedulerServiceHelper userTaskSchedulerServiceHelper;
	
	@Autowired
	UserTaskSchedulerRepository userTaskSchedulerRepository;
	
	@Autowired
	UserTaskSchedulerActivityRepository userTaskSchedulerActivityRepository;

	@Override
	public Page<UserTaskScheduler> getUserTaskByRequest(String srcTaskItem, int pageNumber) {
		//System.out.println(srcTaskItem);
		UserTaskSchedulerRequest releaseItemRequest =  gson.fromJson(srcTaskItem, UserTaskSchedulerRequest.class);
		//System.out.println(releaseItemRequest);
		Pageable pageable = PageRequest.of(pageNumber-1, 50);
		Page<UserTaskScheduler> srcitem = userTaskSchedulerServiceHelper.retrieveReleaseItemByDTORequest(releaseItemRequest, pageable);
		
		return srcitem;
	}

	@Override
	public UserTaskScheduler saveTask(UserTaskScheduler userTaskScheduler) {
		return userTaskSchedulerRepository.save(userTaskScheduler);
	}

	@Override
	public UserTaskScheduler getTaskByID(long taskId) {
		Optional<UserTaskScheduler> userTaskScheduler = userTaskSchedulerRepository.findById(taskId);
		if(userTaskScheduler.isPresent()) {
			return userTaskScheduler.get();
		}
		return null;
	}

	@Override
	public void deleteTaskById(long taskId) {
		userTaskSchedulerRepository.deleteById(taskId);
		
	}

	@Override
	public Page<UserTaskScheduler> findAllUserTask(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("taskScheduledDate").descending());
		return userTaskSchedulerRepository.findAll(pageable);
	}

	@Override
	public List<UserTaskSchedulerActivity> getAllUserTaskSchedulerActivity(long taskId) {
		return userTaskSchedulerActivityRepository.findByTaskSchedulerId(taskId,Sort.by(Sort.Direction.DESC, "activityCreatedDate"));
	}

	@Override
	public UserTaskSchedulerActivity saveTaskSchedulerActivity(UserTaskSchedulerActivity userTaskSchedulerActivity) {
		return userTaskSchedulerActivityRepository.save(userTaskSchedulerActivity);
	}

	@Override
	public UserTaskSchedulerActivity getUserTaskSchedulerActivityById(long taskActivityId) {
		Optional<UserTaskSchedulerActivity> userTaskScheduler = userTaskSchedulerActivityRepository.findById(taskActivityId);
		if(userTaskScheduler.isPresent()) {
			return userTaskScheduler.get();
		}
		return null;
	}

}
