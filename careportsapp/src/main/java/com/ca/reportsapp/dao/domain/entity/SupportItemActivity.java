package com.ca.reportsapp.dao.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2019-12-25 21:39:36.839
 */

@Entity
@Table(name = "support_item_activity")
@Getter
@Setter
@ToString
public class SupportItemActivity implements Serializable{
	
	private static final long serialVersionUID = -989461522191974855L;

	  @Id
	  @Column(name = "support_item_activity_id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long supportItemActivityId;
	  
	  @Column(name = "item_id")
	  private long itemId;
	  
	  @Column(name = "item_activity")
	  private String itemActivity;
	  
	  
	  //@Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "item_activity_date",insertable = false, updatable = false)
	  private Date itemActivityDate;
}
