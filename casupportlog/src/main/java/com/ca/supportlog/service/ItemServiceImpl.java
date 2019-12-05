package com.ca.supportlog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.supportlog.domain.entity.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

	@Override
	public boolean saveStudent(Item items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getItemss() {
		// TODO Auto-generated method stub
		return null;
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
