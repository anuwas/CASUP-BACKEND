/**
 * 
 */
package com.ca.reportsapp.service.impl;

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

import com.ca.reportsapp.dao.SupportItemActivityDAO;
import com.ca.reportsapp.dao.SupportItemDAO;
import com.ca.reportsapp.dao.domain.entity.SupportItem;
import com.ca.reportsapp.dao.domain.entity.SupportItemActivity;
import com.ca.reportsapp.dto.AdvanceSearchSupportItem;
import com.ca.reportsapp.service.SupportItemService;
import com.ca.reportsapp.service.helper.SupportItemServiceHelper;
import com.google.gson.Gson;



/**
 * @author Anupam Biswas
 * 2019-12-25 19:32:43.453
 */
@Service
@Transactional
public class SupportItemServiceImpl implements SupportItemService{

	@Autowired
	SupportItemDAO supportItemDAO;
	
	@Autowired
	SupportItemActivityDAO supportItemActivityDAO;
	
	@Autowired
	Gson gson;
	
	@Autowired
	SupportItemServiceHelper supportItemServiceHelper;

	@Override
	public SupportItem saveItem(SupportItem item) {
		return  supportItemDAO.save(item);
	}

	@Override
	public Page<SupportItem> getAllItem(int pageNumber) {
		//Pageable pageable = PageRequest.of(pageNumber-1, 20, Sort.by("itemType").ascending().and(Sort.by("created_timestamp").descending()));
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("itemCreatedTimestamp").descending());
		return supportItemDAO.findAll(pageable);
	}
	
	@Override
	public Page<SupportItem> getAllItemByItemNumber(int pageNumber, long itenNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("itemCreatedTimestamp").descending());
		return supportItemDAO.findByitemNumber(pageable,itenNumber);
	}
	
	@Override
	public void deleteItemById(long id) {
		supportItemDAO.deleteById(id);
	}

	@Override
	public SupportItem getItemByID(long id) {
		Optional<SupportItem> item = supportItemDAO.findById(id);
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
		itemList.add("Cancel");
		return supportItemDAO.findByitemStatusNotInAndcronicalReportIn(itemList,"N");
	}
	
	@Override
	public List<SupportItem> getActiveProblemRecordItemList() {
		List<String> itemList= new ArrayList<>();
		itemList.add("Closed");
		itemList.add("Resolved");
		itemList.add("Fulfilled");
		itemList.add("Cancel");
		return supportItemDAO.findByProblemRecordStatusNotInAndcronicalReportIn(itemList,"N");
	}
	
	

	@Override
	public List<SupportItemActivity> getSupportItemActivityList(long itemId) {
		return supportItemActivityDAO.findAllByitemId(itemId, Sort.by(Sort.Direction.DESC, "itemActivityDate"));
	}

	@Override
	public SupportItemActivity saveSupportItemActivity(SupportItemActivity supportItemActivity) {
		return supportItemActivityDAO.save(supportItemActivity);
	}

	@Override
	public List<SupportItem> getActiveReportItemList() {
		return supportItemDAO.findBycronicalReport("Y");
	}
	

	@Override
	public Page<SupportItem> getAdvSrcSupportItem(String advanceSearchSupportItem,int pageNumber) {
		// TODO Auto-generated method stub
		System.out.println(advanceSearchSupportItem);
		
		AdvanceSearchSupportItem advSrcAttributes = gson.fromJson(advanceSearchSupportItem, AdvanceSearchSupportItem.class);
		System.out.println(advSrcAttributes);
		//List<SupportItem> srcitem = supportItemServiceHelper.retrieveSupportItem(advSrcAttributes);
		Pageable pageable = PageRequest.of(pageNumber-1, 50);
		Page<SupportItem> srcitem = supportItemServiceHelper.retrieveAdvSrcSupportItemPage(advSrcAttributes,pageable);
		
		//System.out.println(srcitem);
		return srcitem;
		//return null;
	}

	@Override
	public List<SupportItem> getSupportItemForExcel(String advanceSearchSupportItem, String type) {
		AdvanceSearchSupportItem advSrcAttributes = gson.fromJson(advanceSearchSupportItem, AdvanceSearchSupportItem.class);
		return supportItemServiceHelper.retrieveAdvSrcSupportItemForExcell(advSrcAttributes,type);
	}

	@Override
	public List<SupportItem> getActiveItemListByType(String itemType) {
		List<String> itemList= new ArrayList<>();
		itemList.add("Closed");
		itemList.add("Resolved");
		itemList.add("Fulfilled");
		itemList.add("Cancel");
		return supportItemDAO.findByItemTypeAndItemStatusNotInAndCronicalReport(itemType, itemList,"N");
	}
}
