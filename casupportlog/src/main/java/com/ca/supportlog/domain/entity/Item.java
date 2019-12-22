package com.ca.supportlog.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "ITEM")
@Getter
@Setter
@ToString
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
	  
	  @Column(name = "item_created_date",columnDefinition = "TIMESTAMP")
	  private LocalDateTime itemCreatedDate;

	  @Column(name = "item_close_date",columnDefinition = "TIMESTAMP")
	  private LocalDateTime itemCloseDate;
	  
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

}
