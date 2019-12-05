package com.ca.supportlog.controller;

import java.net.URI;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.ca.supportlog.domain.entity.Item;
import com.ca.supportlog.repository.ItemRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/item")
	public List<Item> retrieveAllStudents() {
		return itemRepository.findAll();
	}

	@GetMapping("/item/{id}")
	public Item retrieveStudent(@PathVariable long id) {
		Optional<Item> student = itemRepository.findById(id);

		if (!student.isPresent())
			System.out.println("item not found");

		return student.get();
	}

	@DeleteMapping("/item/{id}")
	public void deleteStudent(@PathVariable long id) {
		itemRepository.deleteById(id);
	}

	@PostMapping("/item")
	public ResponseEntity<Object> createStudent(@RequestBody Item item) {
		Item savedStudent = itemRepository.save(item);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Item item, @PathVariable long id) {

		Optional<Item> studentOptional = itemRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		item.setId(id);
		
		itemRepository.save(item);

		return ResponseEntity.noContent().build();
	}

}
