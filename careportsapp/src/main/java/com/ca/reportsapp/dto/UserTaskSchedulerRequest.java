/**
 * 
 */
package com.ca.reportsapp.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2020-04-10 22:17:54.442
 */
@Component
@Getter
@Setter
@ToString
public class UserTaskSchedulerRequest {
	
	private String taskStatus;
	private String priority;
	private Date taskScheduledStartDate;
	private Date taskScheduledEndDate;
	private String followUpTo;

}
