/**
 * 
 */
package com.ca.reportsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ca.reportsapp.dao.domain.entity.Releases;
import com.ca.reportsapp.dao.domain.entity.SmartOperation;
import com.ca.reportsapp.dao.domain.entity.SupportItem;
import com.ca.reportsapp.dao.repository.SmartOperationRepository;

/**
 * @author Anupam Biswas
 * 2020-05-02 21:38:07.841
 */
@RestController
//@CrossOrigin(origins="${rest.client.origin}")
@RequestMapping(value="/api/smartoperation")
public class SmartOperationController {
	
	@Autowired
	SmartOperationRepository smartOperationRepository;

	@GetMapping("/operation")
	public List<SmartOperation> retriveAllSmartOperation() {
		return (List<SmartOperation>) smartOperationRepository.findAll();
	}
	
	@PostMapping("/operation")
	public ResponseEntity<Object> saveOperation(@RequestBody SmartOperation item,UriComponentsBuilder builder) {
		smartOperationRepository.save(item);
		HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/operation")
	public ResponseEntity<Object> saveOperation(@RequestBody SmartOperation item,UriComponentsBuilder builder,@PathVariable int itemId) {
		smartOperationRepository.save(item);
		HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Object>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/operation/{comment}")
	public List<SmartOperation> retriveAllSmartOperation(@PathVariable String comment) {
		return (List<SmartOperation>) smartOperationRepository.findByComment(comment);
	}
	
}
