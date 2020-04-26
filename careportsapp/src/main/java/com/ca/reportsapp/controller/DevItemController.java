package com.ca.reportsapp.controller;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.ca.reportsapp.dao.domain.entity.DevDailyScrumStatus;
import com.ca.reportsapp.dao.domain.entity.DevItem;
import com.ca.reportsapp.dao.domain.entity.DevSprint;
import com.ca.reportsapp.dao.repository.DevItemRepository;
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
	
	@Autowired
	DevItemRepository devItemRepository;
	
	@GetMapping("/all-item-list/{pageNumber}")
	public Page<DevItem> retrieveAllItems(@PathVariable int pageNumber) {
		return devtItemService.findAllDevItem(pageNumber);
	}
	
	@GetMapping("/current-sprint-item/{currentSprint}")
	public List<DevItem> retrieveCurrentSprintItems(@PathVariable String currentSprint) {
		return devtItemService.findCurrentSprintItem(currentSprint);
	}
	
	@GetMapping("/all-dev-item/{page}/{devitemparam}")
	public Page<DevItem> retrieveDevItems(@PathVariable int page,@PathVariable String devitemparam) {
		 return devtItemService.getDevItemByRequest(devitemparam, page);
	}
	
	@PostMapping("/save-dev-item")
	public ResponseEntity<Object> createItem(@RequestBody DevItem item,UriComponentsBuilder builder) {
		DevItem savedItem = devtItemService.saveItem(item);

		/*
		 * URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/item/{id}")
		 * .buildAndExpand(savedStudent.getId()).toUri();
		 * 
		 * return ResponseEntity.created(location).build();
		 */
		System.err.println(savedItem.getDevItemId());
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("item/{id}").buildAndExpand(savedItem.getDevItemId()).toUri());
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);

	}
	
	@GetMapping("/devitem/{devItemId}")
	public DevItem retrieveItem(@PathVariable long devItemId) {
		return devtItemService.getItemByID(devItemId);	
	}
	
	@DeleteMapping("/devitem/{devItemId}")
	public void deleteStudent(@PathVariable long devItemId) {
		devtItemService.deleteItemById(devItemId);
	}
	
	@PutMapping("/devitem/{devItemId}")
	public ResponseEntity<Object> updateItem(@RequestBody DevItem item, @PathVariable long devItemId) {
		
		Optional<DevItem> itemOptional = devItemRepository.findById(devItemId);

		if (!itemOptional.isPresent())
			return ResponseEntity.notFound().build();

		item.setDevItemId(devItemId);
		
		devtItemService.saveItem(item);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/dev-item-status/{devItem}")
	public List<DevDailyScrumStatus> retriveItemAllStatusByItem(@PathVariable String devItem) {
		return devtItemService.getDailyStatusByDevItem(devItem);
	}
	
	@GetMapping("/get-item-status/{itemStatusId}")
	public DevDailyScrumStatus retriveItemStatusByItem(@PathVariable long itemStatusId) {
		return devtItemService.getItemStatuById(itemStatusId);
	}
	
	@PostMapping("/save-item-daily-status")
	public ResponseEntity<Object> createItem(@RequestBody DevDailyScrumStatus item,UriComponentsBuilder builder) {
	DevDailyScrumStatus savedItem = devtItemService.saveDailyStatus(item);

		
	HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("get-item-status/{itemStatusId}").buildAndExpand(savedItem.getDailyScrumId()).toUri());
    return new ResponseEntity<Object>(headers,HttpStatus.CREATED);

	}
	
	@GetMapping("/all-dev-sprints/{page}/{devitemparam}")
	public Page<DevSprint> retriveAllDevSprints(@PathVariable int pageNumber,@PathVariable String srcDevSprint) {
		 return devtItemService.getDevSprintsByRequest(srcDevSprint, pageNumber);
	}
	
	@GetMapping("/get-dev-sprint/{currentSprint}")
	public DevSprint retrieveDevSprint(@PathVariable long devSprintId) {
		return devtItemService.getDevSprintById(devSprintId);
	}
	
	@PutMapping("/update-dev-sprint/{devItemId}")
	public ResponseEntity<Object> updateDevSprint(@RequestBody DevSprint item, @PathVariable long devItemId) {
		
		DevSprint itemOptional = devtItemService.getDevSprintById(devItemId);

		if (itemOptional==null)
			return ResponseEntity.notFound().build();

		item.setSprintId(devItemId);
		
		devtItemService.saveDevSprint(item);

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/save-dev-sprint")
	public ResponseEntity<Object> createNewDevSprint(@RequestBody DevSprint item,UriComponentsBuilder builder) {
		DevSprint savedItem = devtItemService.saveDevSprint(item);

		
		System.err.println(savedItem.getSprintId());
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("get-dev-sprint/{devItemId}").buildAndExpand(savedItem.getSprintId()).toUri());
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);

	}
	
	@DeleteMapping("/devsprint/{devItemId}")
	public void deleteDevSprint(@PathVariable long devItemId) {
		devtItemService.deleteDevSprint(devItemId);
	}

}
