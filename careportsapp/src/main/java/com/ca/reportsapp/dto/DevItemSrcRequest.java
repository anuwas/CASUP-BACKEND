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
 * 2020-01-12 01:42:39.730
 */
@Component
@Getter
@Setter
@ToString
public class DevItemSrcRequest {
	
	private String itemNumber;
	private String itemSprintName;
	private String itemStatus;
	private String applicationName;
	private String itemPriority;
	private boolean isRefined;
	private String projectName;
	private String itemType;
	private String developerName;	
}
