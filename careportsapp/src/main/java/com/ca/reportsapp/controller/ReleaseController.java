/**
 * 
 */
package com.ca.reportsapp.controller;

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

import com.ca.reportsapp.dao.domain.entity.Releases;
import com.ca.reportsapp.dao.repository.ReleaseRepository;
import com.ca.reportsapp.service.ReleaseService;

/**
 * @author Anupam Biswas
 * 2020-03-15 12:28:27.997
 */
@RestController
@CrossOrigin(origins="${rest.client.origin}")
@RequestMapping(value="/api/releases")
public class ReleaseController {
	
	@Autowired
	ReleaseService releaseService;
	
	@Autowired
	ReleaseRepository releaseRepository;
	
	@GetMapping("/all-release-item-list/{pageNumber}")
	public Page<Releases> retrieveAllItems(@PathVariable int pageNumber) {
		return releaseService.findAllReleases(pageNumber);
	}
	
	@GetMapping("/all-release-item-list/{page}/{devitemparam}")
	public Page<Releases> retrieveReleaseItems(@PathVariable int page,@PathVariable String devitemparam) {
		 return releaseService.getReleaseItemByRequest(devitemparam, page);
	}
	
	@PostMapping("/save-release-item")
	public ResponseEntity<Object> createItem(@RequestBody Releases item,UriComponentsBuilder builder) {
		Releases savedItem = releaseService.saveReleaseItem(item);

		/*
		 * URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/item/{id}")
		 * .buildAndExpand(savedStudent.getId()).toUri();
		 * 
		 * return ResponseEntity.created(location).build();
		 */
		System.err.println(savedItem.getReleaseId());
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("item/{id}").buildAndExpand(savedItem.getReleaseId()).toUri());
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);

	}
	
	@PutMapping("/update-release-item/{releaseItemId}")
	public ResponseEntity<Object> updateItem(@RequestBody Releases item, @PathVariable long releaseItemId) {
		
		Optional<Releases> itemOptional = releaseRepository.findById(releaseItemId);

		if (!itemOptional.isPresent())
			return ResponseEntity.notFound().build();

		item.setReleaseId(releaseItemId);
		
		releaseService.saveReleaseItem(item);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete-release-item/{releaseItemId}")
	public void deleteStudent(@PathVariable long releaseItemId) {
		releaseService.deleteReleaseItemById(releaseItemId);
	}
	
	@GetMapping("/view-release-item/{releaseItemId}")
	public Releases retrieveItem(@PathVariable long releaseItemId) {
		return releaseService.getReleaseItemByID(releaseItemId);
	}

}
