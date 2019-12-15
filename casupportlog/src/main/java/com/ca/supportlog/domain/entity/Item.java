package com.ca.supportlog.domain.entity;

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
	  
	  @Column(name = "item_created_by")
	  private String itemCreatedBy;
	  
	  @Column(name = "associated_item")
	  private String associatedItem;
	  
	  @Column(name = "item_created_date")
	  private Date itemCreatedDate;

	  @Column(name = "item_close_date")
	  private Date itemCloseDate;
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "item_created_timestamp")
	  private Date itemCreatedTimestamp;

}
