/**
 * 
 */
package com.ca.reportsapp.service;

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

import com.ca.reportsapp.domain.entity.SupportItem;
import com.ca.reportsapp.domain.entity.SupportItemActivity;
import com.ca.reportsapp.repository.SupportItemActivityRepository;
import com.ca.reportsapp.repository.SupportItemRepository;

/**
 * @author Anupam Biswas
 * 2019-12-25 19:32:43.453
 */
@Service
@Transactional
public class SupportItemServiceImpl implements SupportItemService{

	@Autowired
	SupportItemRepository supportItemRepository;
	
	@Autowired
	SupportItemActivityRepository supportItemActivityRepository;

	@Override
	public SupportItem saveItem(SupportItem item) {
		return  supportItemRepository.save(item);
	}

	@Override
	public Page<SupportItem> getAllItem(int pageNumber) {
		//Pageable pageable = PageRequest.of(pageNumber-1, 20, Sort.by("itemType").ascending().and(Sort.by("created_timestamp").descending()));
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("itemCreatedTimestamp").descending());
		return supportItemRepository.findAll(pageable);
	}
	
	@Override
	public Page<SupportItem> getAllItemByItemNumber(int pageNumber, long itenNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("itemCreatedTimestamp").descending());
		return supportItemRepository.findByitemNumber(pageable,itenNumber);
	}
	
	@Override
	public void deleteItemById(long id) {
		supportItemRepository.deleteById(id);
	}

	@Override
	public SupportItem getItemByID(long id) {
		Optional<SupportItem> item = supportItemRepository.findById(id);
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
	public List<SupportItem> getActiveItemList() {
		List<String> itemList= new ArrayList<>();
		itemList.add("Closed");
		itemList.add("Resolved");
		itemList.add("Fulfilled");
		
		return supportItemRepository.findByitemStatusNotIn(itemList);
	}

	@Override
	public List<SupportItemActivity> getSupportItemActivityList(long itemId) {
		return supportItemActivityRepository.findAllByitemId(itemId, Sort.by(Sort.Direction.DESC, "itemActivityDate"));
	}

	@Override
	public SupportItemActivity saveSupportItemActivity(SupportItemActivity supportItemActivity) {
		return supportItemActivityRepository.save(supportItemActivity);
	}
}
