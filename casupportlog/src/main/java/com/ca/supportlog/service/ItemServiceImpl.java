package com.ca.supportlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.supportlog.domain.entity.Item;
import com.ca.supportlog.repository.ItemRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public boolean saveStudent(Item items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Item> getAllItem() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("itemType").ascending().and(Sort.by("workingOn").descending()));		
		return itemRepository.findAll(pageable);
	}

	@Override
	public boolean deleteStudent(Item items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getStudentByID(Item items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStudent(Item items) {
		// TODO Auto-generated method stub
		return false;
	}

}
