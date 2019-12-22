package com.ca.supportlog.controller;

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

import com.ca.supportlog.domain.entity.Item;
import com.ca.supportlog.repository.ItemRepository;
import com.ca.supportlog.service.ItemService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/all-item-list/{pageNumber}")
	public Page<Item> retrieveAllItems(@PathVariable int pageNumber) {
		return itemService.getAllItem(pageNumber);
	}
	
	@GetMapping("/all-item-list/{pageNumber}/{itemNumber}")
	public Page<Item> retrieveAllItems(@PathVariable int pageNumber,@PathVariable long itemNumber) {
		return itemService.getAllItemByItemNumber(pageNumber, itemNumber);
	}
	
	@GetMapping("/active-item-list")
	public List<Item> retrieveAllActiveItems() {
		return itemService.getActiveItemList();
	}

	@GetMapping("/item/{id}")
	public Item retrieveItem(@PathVariable long id) {
		return itemService.getItemByID(id);	
	}

	@DeleteMapping("/item/{id}")
	public void deleteStudent(@PathVariable long id) {
		itemService.deleteItemById(id);
	}

	@PostMapping("/save-item")
	public ResponseEntity<Object> createItem(@RequestBody Item item,UriComponentsBuilder builder) {
		Item savedItem = itemService.saveItem(item);

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
	public ResponseEntity<Object> updateItem(@RequestBody Item item, @PathVariable long id) {
		
		Optional<Item> itemOptional = itemRepository.findById(id);

		if (!itemOptional.isPresent())
			return ResponseEntity.notFound().build();

		item.setId(id);
		
		itemRepository.save(item);

		return ResponseEntity.noContent().build();
	}

}
