/**
 * 
 */
package com.ca.reportsapp.dao.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2020-04-13 01:21:49.206
 */
@Entity
@Table(name = "user_task_scheduler_activity")
@Getter
@Setter
@ToString
public class UserTaskSchedulerActivity implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -4888121497982063586L;
	
	@Id
	@Column(name = "user_task_scheduler_activity_id")
	private long taskSchedulerActivityId;
	
	@Column(name = "task_scheduler_id")
	private long taskSchedulerId;
	
	
	@Column(name = "task_activity")
	private String taskActivity;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "activity_created_date",insertable = false, updatable = false)
	private java.util.Date activityCreatedDate;

}
