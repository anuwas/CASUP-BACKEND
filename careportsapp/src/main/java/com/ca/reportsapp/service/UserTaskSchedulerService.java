/**
 * 
 */
package com.ca.reportsapp.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ca.reportsapp.dao.domain.entity.UserTaskScheduler;

/**
 * @author Anupam Biswas
 * 2020-04-10 22:09:36.471
 */
@Service
public interface UserTaskSchedulerService {
	public Page<UserTaskScheduler> findAllUserTask(int pageNumber);
	public Page<UserTaskScheduler> getUserTaskByRequest(String srcTaskItem,int pageNumber); 
	public UserTaskScheduler saveTask(UserTaskScheduler userTaskScheduler);
	public UserTaskScheduler getTaskByID(long taskId);
	public void deleteTaskById(long taskId);
}
