package com.ca.supportlog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public Item saveItem(Item item) {
		return  itemRepository.save(item);
	}

	@Override
	public Page<Item> getAllItem(int pageNumber) {
		//Pageable pageable = PageRequest.of(pageNumber-1, 20, Sort.by("itemType").ascending().and(Sort.by("created_timestamp").descending()));
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("itemCreatedTimestamp").descending());
		return itemRepository.findAll(pageable);
	}
	
	@Override
	public Page<Item> getAllItemByItemNumber(int pageNumber, long itenNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("itemCreatedTimestamp").descending());
		return itemRepository.findByitemNumber(pageable,itenNumber);
	}
	
	@Override
	public void deleteItemById(long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public Item getItemByID(long id) {
		Optional<Item> item = itemRepository.findById(id);
		if (!item.isPresent())
			System.out.println("item not found");

		return item.get();
	}

	@Override
	public boolean updateItemById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getActiveItemList() {
		List<String> itemList= new ArrayList<>();
		itemList.add("closed");
		itemList.add("resolved");
		
		return itemRepository.findByitemStatusNotIn(itemList);
	}

	

}
