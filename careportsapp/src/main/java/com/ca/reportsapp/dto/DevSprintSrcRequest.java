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
 * 2020-04-26 00:53:07.203
 */
@Component
@Setter
@Getter
@ToString
public class DevSprintSrcRequest {
	
	private String sprintName;
	private Date itemFromDate;
    private Date itemToDate;
	private boolean scopeScreep;
	private String isSpillOver;
	private boolean opneDate;
    private boolean closeDate;

}
