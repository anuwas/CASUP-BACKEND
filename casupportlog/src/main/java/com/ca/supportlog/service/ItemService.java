package com.ca.supportlog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ca.supportlog.domain.entity.Item;



public interface ItemService {
	public Item saveItem(Item item);
	public Page<Item> getAllItem(int pageNumber);
	public Page<Item> getAllItemByItemNumber(int pageNumber,long itenNumber);
	public void deleteItemById(long id);
	public Item getItemByID(long id);
	public boolean updateItemById(long id);
	public List<Item> getActiveItemList();
}
