/**
 * 
 */
package com.ca.reportsapp.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2020-01-05 02:51:13.240
 */
@Component
@Getter
@Setter
@ToString
public class AdvanceSearchSupportItem {
	
	private long itemNumber;
    private Date itemCreatedDate;
    private Date itemCloseDate;
    private boolean opneDate;
    private boolean closeDate;
    private String applicationName;
    private boolean bounce;
    private String itemStatus;
    private String itemType;
    private String itemAssigned;
    private String sla;
    private String debt;
    private int priority;

}
