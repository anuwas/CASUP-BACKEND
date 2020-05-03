/**
 * 
 */
package com.ca.reportsapp.dao.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Anupam Biswas
 * 2020-04-28 00:45:25.399
 */
@Entity
@Table(name = "configuration_properties")
@Getter
@Setter
@ToString
public class AppConfigurationProperties implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2739000960199187863L;
	
	@Id
	@Column(name = "configuration_properties_id")
	private long configurationPropertiesId;
	
	@Column(name = "config_name")
	private String configName;
	
	@Column(name = "config_value")
	private String configValue;

}
