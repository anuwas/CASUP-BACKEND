package com.ca.supportlog.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "ITEM")
@Getter
@Setter
@ToString
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  @Id
	  @Column(name = "item_id")
	  private long id;
	  
	  @Column(name = "item_type")
	  private String itemType;
	  
	  @Column(name = "working_on")
	  private String workingOn;
	  
	  @Column(name = "item_status")
	  private String itemStatus;
	  
	  @Column(name = "created_on")
	  private String createdOn;

	

}
