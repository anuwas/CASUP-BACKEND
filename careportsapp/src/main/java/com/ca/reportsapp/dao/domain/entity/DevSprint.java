/**
 * 
 */
package com.ca.reportsapp.dao.domain.entity;

import java.io.Serializable;
import java.util.Date;

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
 * 2020-01-11 23:02:35.819
 */
@Entity
@Table(name = "dev_sprint")
@Getter
@Setter
@ToString
public class DevSprint implements Serializable{
	
	
	private static final long serialVersionUID = 2161898651335178720L;

	@Id
	@Column(name = "sprint_id")
	private long sprintId;
	
	@Column(name = "sprint_name")
	private String sprintName;
	 
	@Temporal(TemporalType.DATE)
	@Column(name = "sprint_open_date")
	private java.util.Date sprintOpenDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "sprint_close_date")
	private java.util.Date sprintCloseDate;
	  
	@Column(name = "committed_story_point")
	private long committedStoryPoint;
	  
	@Column(name = "deliverd_story_point")
	private long deliverdStoryPoint;
	  
	//@Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "sprint_created_date",insertable = false, updatable = false)
	  private Date sprintCreatedDate;

}
