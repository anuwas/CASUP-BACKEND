/**
 * 
 */
package com.ca.reportsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ca.reportsapp.dao.domain.entity.DevItem;
import com.ca.reportsapp.dao.domain.entity.SupportItem;
import com.ca.reportsapp.service.DevtItemService;

/**
 * @author Anupam Biswas
 * 2020-01-12 00:50:13.579
 */
@RestController
@CrossOrigin(origins="${rest.client.origin}")
@RequestMapping(value="/api/dev")
public class DevItemController {
	
	@Autowired
	DevtItemService devtItemService;
	
	@GetMapping("/all-item-list/{pageNumber}")
	public Page<DevItem> retrieveAllItems(@PathVariable int pageNumber) {
		return devtItemService.findAllDevItem(pageNumber);
	}
	
	@GetMapping("/all-dev-item/{page}/{devitemparam}")
	public Page<DevItem> retrieveDevItems(@PathVariable int page,@PathVariable String devitemparam) {
		 return devtItemService.getDevItemByRequest(devitemparam, page);
	}

}
