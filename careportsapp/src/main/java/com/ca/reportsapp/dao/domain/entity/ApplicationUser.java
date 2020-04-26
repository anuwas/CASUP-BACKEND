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
 * 2020-04-15 01:31:32.801
 */
@Entity
@Table(name = "application_user")
@Getter
@Setter
@ToString
public class ApplicationUser implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7182777836396093046L;
	
	@Id
	@Column(name = "application_user_id")
	private long applicationUserId;
	
	@Column(name = "user_role")
	private String userRole;
	
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_full_name")
	private String userFullName;
	
	@Column(name = "password")
	private String password;

}
