/**
 * 
 */
package com.ca.reportsapp.dao.domain.entity;

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
 * 2020-05-02 21:32:56.175
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "smart_operation")
public class SmartOperation {

	@Id
	@Column(name = "smart_operation_id")
	private long smartOperationId;
	
	@Column(name = "comment")
	private String comment;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "operation_date")
	private java.util.Date operationDate;
	
}
