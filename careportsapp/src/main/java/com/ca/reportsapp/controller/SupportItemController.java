package com.ca.reportsapp.controller;

import java.net.URI;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.ca.reportsapp.dao.domain.entity.SupportItem;
import com.ca.reportsapp.dao.domain.entity.SupportItemActivity;
import com.ca.reportsapp.dao.repository.SupportItemRepository;
import com.ca.reportsapp.dto.AdvanceSearchSupportItem;
import com.ca.reportsapp.service.SupportItemService;

/**
 * @author Anupam Biswas
 * 2019-12-25 19:05:43.534
 */
@RestController
@CrossOrigin(origins="${rest.client.origin}")
@RequestMapping(value="/api")
public class SupportItemController {
	
	@Autowired
	private SupportItemRepository supportItemRepository;
	
	@Autowired
	private SupportItemService supportItemService;

	@GetMapping("/all-item-list/{pageNumber}")
	public Page<SupportItem> retrieveAllItems(@PathVariable int pageNumber) {
		return supportItemService.getAllItem(pageNumber);
	}
	
	@GetMapping("/all-item-list/{pageNumber}/{itemNumber}")
	public Page<SupportItem> retrieveAllItems(@PathVariable int pageNumber,@PathVariable long itemNumber) {
		return supportItemService.getAllItemByItemNumber(pageNumber, itemNumber);
	}
	
	@GetMapping("/active-item-list")
	public List<SupportItem> retrieveAllActiveItems() {
		return supportItemService.getActiveItemList();
	}

	@GetMapping("/item/{id}")
	public SupportItem retrieveItem(@PathVariable long id) {
		return supportItemService.getItemByID(id);	
	}

	@DeleteMapping("/item/{id}")
	public void deleteStudent(@PathVariable long id) {
		supportItemService.deleteItemById(id);
	}

	@PostMapping("/save-item")
	public ResponseEntity<Object> createItem(@RequestBody SupportItem item,UriComponentsBuilder builder) {
		SupportItem savedItem = supportItemService.saveItem(item);

		/*
		 * URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/item/{id}")
		 * .buildAndExpand(savedStudent.getId()).toUri();
		 * 
		 * return ResponseEntity.created(location).build();
		 */
		System.err.println(savedItem.getId());
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("item/{id}").buildAndExpand(savedItem.getId()).toUri());
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);

	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Object> updateItem(@RequestBody SupportItem item, @PathVariable long id) {
		
		Optional<SupportItem> itemOptional = supportItemRepository.findById(id);

		if (!itemOptional.isPresent())
			return ResponseEntity.notFound().build();

		item.setId(id);
		
		supportItemRepository.save(item);

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/save-supitem-activity")
	public ResponseEntity<Object> createSupItemActivity(@RequestBody SupportItemActivity supportItemActivity,UriComponentsBuilder builder) {
		SupportItemActivity savedItem = supportItemService.saveSupportItemActivity(supportItemActivity);

		/*
		 * URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/item/{id}")
		 * .buildAndExpand(savedStudent.getId()).toUri();
		 * 
		 * return ResponseEntity.created(location).build();
		 */
		System.out.println(savedItem.getSupportItemActivityId());
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("item/{id}").buildAndExpand(savedItem.getSupportItemActivityId()).toUri());
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/sup-item-activity-list/{itemId}")
	public List<SupportItemActivity> retrieveSupportItemActivityByItemId(@PathVariable int itemId) {
		return supportItemService.getSupportItemActivityList(itemId);
	}
	
	@GetMapping("/sup-item-active-report-list")
	public List<SupportItem> retrieveSupportItemActiveReport() {
		return supportItemService.getActiveReportItemList();
	}
	
	@GetMapping("/sup-item-active-problem-record-list")
	public List<SupportItem> retrieveSupportItemActiveProblemRecord() {
		return supportItemService.getActiveProblemRecordItemList();
	}
	
	@GetMapping("/all-src-item-list/{page}/{srcsupitemstr}")
	public Page<SupportItem> retrieveAdvanceSearchSupportItem(@PathVariable int page,@PathVariable String srcsupitemstr) {
		return supportItemService.getAdvSrcSupportItem(srcsupitemstr,page);
	}
	
	@GetMapping("/all-src-item-list-excel-export/{srcsupitemstr}/{type}")
	public List<SupportItem> retrieveAdvanceSearchSupportItemExcelExport(@PathVariable String srcsupitemstr,@PathVariable String type) {
		return supportItemService.getSupportItemForExcel(srcsupitemstr,type);
	}
}
