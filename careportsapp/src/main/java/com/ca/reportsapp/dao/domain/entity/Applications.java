/**
 * 
 */
package com.ca.reportsapp.dao.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2020-04-15 01:28:17.265
 */
@Entity
@Table(name = "applications")
@Getter
@Setter
@ToString
public class Applications implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -7270463025917465218L;
	
	@Id
	@Column(name = "applications_id")
	private long applicationsId;
	
	@Column(name = "application_name")
	private String applicationName;
	
	@Column(name = "application_description")
	private String applicationDescription;

}
