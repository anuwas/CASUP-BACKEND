package com.ca.supportlog.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ca.supportlog.domain.entity.Item;



public interface ItemService {
	public boolean saveStudent(Item items);
	public Page<Item> getAllItem();
	public boolean deleteStudent(Item items);
	public List<Item> getStudentByID(Item items);
	public boolean updateStudent(Item items);
}
