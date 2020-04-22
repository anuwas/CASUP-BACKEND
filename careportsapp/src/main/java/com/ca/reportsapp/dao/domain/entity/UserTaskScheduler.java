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
 * 2020-04-10 21:43:59.726
 */
@Entity
@Table(name = "user_task_scheduler")
@Getter
@Setter
@ToString
public class UserTaskScheduler implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 3535151104004535716L;
	
	@Id
	@Column(name = "task_scheduler_id")
	private long taskSchedulerId;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "follow_up_to")
	private String followUpTo;
	
	@Column(name = "task_status")
	private String taskStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_scheduled_date")
	private java.util.Date taskScheduledDate;
	
	@Column(name = "comment")
	private String comment;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_created_date",insertable = false, updatable = false)
	private java.util.Date taskCreatedDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_modified_date",insertable = false, updatable = false)
	private java.util.Date taskModifiedDate;
	
	

}
