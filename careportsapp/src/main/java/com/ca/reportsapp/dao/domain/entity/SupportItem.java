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
 * 2019-12-25 19:18:36.648
 */

@Entity
@Table(name = "support_item")
@Getter
@Setter
@ToString
public class SupportItem implements Serializable{

	private static final long serialVersionUID = -8842676110867055903L;

	@Id
	  @Column(name = "item_id")
	  private long id;
	  
	  @Column(name = "item_number")
	  private long itemNumber;
	  
	  @Column(name = "item_type")
	  private String itemType;
	  
	  @Column(name = "item_subject")
	  private String itemSubject;
	  
	  @Column(name = "item_owner")
	  private String itemOwner;
	  
	  @Column(name = "item_status")
	  private String itemStatus;
	  
	  @Column(name = "item_description")
	  private String itemDescription;
	  
	  @Column(name = "item_assigned")
	  private String itemAssigned;
	  
	  @Column(name = "associated_item")
	  private String associatedItem;
	  	  
	  //@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "item_created_date")
	  private java.util.Date itemCreatedDate;

	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "item_close_date")
	  private java.util.Date itemCloseDate;
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "item_created_timestamp",insertable = false, updatable = false)
	  private java.util.Date itemCreatedTimestamp;
	  
	  @Column(name = "application_name")
	  private String applicationName;
	  
	  @Column(name = "priority")
	  private int priority;
	  
	  @Column(name = "aged",insertable = false)
	  private String aged;
	  
	  @Column(name = "bounce",insertable = false)
	  private int bounce;
	  
	  @Column(name = "primary_sla_breached",insertable = false)
	  private String primarySlaBreached;
	 
	  @Column(name = "secondary_sla_breached",insertable = false)
	  private String secondarySlaBreached;
	 
	  @Column(name = "tertiry_sla_breached",insertable = false)
	  private String tertirySlaBreached;
	 
	  @Column(name = "resoluation",insertable = false)
	  private String resoluation;
	  
	  @Column(name = "cronical_report",insertable = false,updatable = false)
	  private String cronicalReport;
	  
	  @Column(name = "revised_tower")
	  private String revisedTower;
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "aged_on_date",insertable = false, updatable = true)
	  private java.util.Date agedOnDate;
	  
	  @Column(name = "breach_justification")
	  private String breachJustification;
	  
	  @Column(name = "aged_justification")
	  private String agedJustification;
	  
	  @Column(name = "debt_class")
	  private String debtClass;
	  
	  @Column(name = "debt_type")
	  private String debtType;
	  
	  @Column(name = "debt_remedial_mechanism")
	  private String debtRemedialMechanism;
	  
	  @Column(name = "debt_comment")
	  private String debtComment;
	  
	  @Column(name = "rca_document")
	  private String rcaDocument;
	  
	  @Temporal(TemporalType.DATE)
	  @Column(name = "document_shared_date")
	  private java.util.Date documentSharedDate;
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "modified_datetime",insertable = false, updatable = false)
	  private java.util.Date modifiedDatetime;
	  
}
