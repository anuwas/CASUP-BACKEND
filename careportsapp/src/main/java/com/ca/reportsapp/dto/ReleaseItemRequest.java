/**
 * 
 */
package com.ca.reportsapp.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2020-03-15 12:41:17.228
 */
@Component
@Getter
@Setter
@ToString
public class ReleaseItemRequest {
	private String itemSubject;
	private String applicationName;
	private java.util.Date uatRelaseDate;
	private String uatRfcNumber;
	private java.util.Date prdReleaseDate;
	private String prdRfcNumber;
}
