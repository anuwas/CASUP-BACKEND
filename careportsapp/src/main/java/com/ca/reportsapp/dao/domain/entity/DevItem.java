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
 * 2020-01-11 21:57:13.176
 */
@Entity
@Table(name = "dev_item")
@Getter
@Setter
@ToString
public class DevItem implements Serializable{
	

	private static final long serialVersionUID = 6899771039113034568L;

	@Id
	@Column(name = "dev_item_id")
	private long devItemId;
	
	 @Column(name = "item_parent_id")
	  private long itemParentId;
	 
	 @Column(name = "item_number")
	  private String itemNumber;
	 
	 @Column(name = "item_type")
	  private String itemType;
	 
	 @Column(name = "item_sub_type")
	  private String itemSubType;
	 
	 @Column(name = "item_status")
	  private String itemStatus;
	 
	 @Column(name = "item_sprint_id")
	  private long itemSprintId;
	 
	 @Column(name = "item_sprint_name")
	  private String itemSprintName;
	 
	 @Column(name = "item_sprint_status")
	  private String itemSprintStatus;
	 
	 @Column(name = "item_sprint_status_comment")
	  private String itemSprintStatusComment;
	 
	 @Column(name = "item_subject")
	  private String itemSubject;
	 
	 @Column(name = "item_description")
	  private String itemDescription;
	 
	 @Column(name = "item_acceptance_ctriteria")
	  private String itemAcceptanceCtriteria;
	 
	 @Column(name = "item_epic_name")
	  private String itemEpicName;
	 
	 @Column(name = "item_current_board")
	  private String itemCurrentBoard;
	 
	 @Column(name = "application_name")
	  private String applicationName;
	 
	 @Column(name = "is_refined")
	  private String isRefined;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "refine_date")
	  private java.util.Date refineDate;
	 
	 @Column(name = "refine_comment")
	  private String refineComment;
	 
	 @Column(name = "link_item")
	  private String linkItem;
	 
	 @Column(name = "link_comment")
	  private String linkComment;
	 
	 @Column(name = "developer_name")
	  private String developerName;
	 
	 @Column(name = "tester_name")
	  private String testerName;

	 @Column(name = "onboared_sprint")
	  private String onboaredSprint;
	 
	 @Column(name = "delivered_sprint")
	  private String deliveredSprint;
	 
	 @Column(name = "delivery_status")
	  private String deliveryStatus;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "item_sys_release_date")
	 private java.util.Date itemSysReleaseDate;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "item_qa_release_date")
	 private java.util.Date itemQaReleaseDate;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "item_uat_release_date")
	 private java.util.Date itemUatReleaseDate;
	 
	 @Column(name = "item_uat_rfc")
	  private String itemUatRfc;
	 
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "item_prd_release_date")
	 private java.util.Date itemPrdReleaseDate;
	 
	 @Column(name = "item_prd_rfc")
	  private String itemPrdRfc;
	 
	 @Column(name = "item_uat_bug_count")
	  private String itemUatBugCount;
	 
	 @Column(name = "item_prd_bug_count")
	  private String itemPrdBugCount;
	 

	 @Column(name = "project_name")
	  private String projectName;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "item_created_timestamp",insertable = false, updatable = false)
	  private java.util.Date itemCreatedTimestamp;

}
