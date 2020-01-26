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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2020-01-11 22:55:10.045
 */
@Entity
@Table(name = "dev_daily_scrum")
@Getter
@Setter
@ToString
public class DevDailyScrum implements Serializable{
	
	
	private static final long serialVersionUID = -1679413319425164499L;

		@Id
		@Column(name = "daily_scrum_id")
		private long dailyScrumId;
		
		@Column(name = "sprint_id")
		private long sprintId;
		
		@Column(name = "dev_item_id")
		private long devItemId;
		
		 @Column(name = "current_status")
		  private String currentStatus;
		 
		 @Column(name = "developer_name")
		  private String developerName;
		 
		 @Column(name = "tester_name")
		  private String testerName;
		 
		 @Column(name = "status_date",insertable = false, updatable = false)
		  private Date statusDate;

}
