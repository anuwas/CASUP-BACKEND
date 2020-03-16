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
 * 2020-03-15 02:58:23.996
 */
@Entity
@Table(name = "releases")
@Getter
@Setter
@ToString
public class Releases implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7123731001134177441L;
	
	@Id
	@Column(name = "release_id")
	private long releaseId;
	
	@Column(name = "item_subject")
	private String itemSubject;
	
	@Column(name = "item_description")
	private String itemDescription;
	
	@Column(name = "application_name")
	private String applicationName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "uat_start_date")
	private java.util.Date uatStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "uat_signoff_date")
	private java.util.Date uatSignoffDate;
	
	@Column(name = "uat_rfc_number")
	private long uatRfcNumber;
	
	@Column(name = "post_uat_bug_count")
	private int postUatBugCount;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "prd_release_date")
	private java.util.Date prdReleaseDate;
	
	@Column(name = "prd_rfc_number")
	private long prdRfcNumber;
	
	@Column(name = "post_prd_bug_count")
	private int postPrdBugCount;
	
	@Column(name = "comment")
	private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "item_created_timestamp",insertable = false, updatable = false)
	private java.util.Date itemCreatedTimestamp;
	

}
