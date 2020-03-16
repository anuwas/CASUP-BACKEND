/**
 * 
 */
package com.ca.reportsapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ca.reportsapp.dao.domain.entity.SupportItem;
import com.ca.reportsapp.dao.domain.entity.SupportItemActivity;



/**
 * @author Anupam Biswas
 * 2019-12-25 19:30:03.793
 */
public interface SupportItemService {

	public SupportItem saveItem(SupportItem item);
	public Page<SupportItem> getAllItem(int pageNumber);
	public Page<SupportItem> getAllItemByItemNumber(int pageNumber,long itenNumber);
	public void deleteItemById(long id);
	public SupportItem getItemByID(long id);
	public boolean updateItemById(long id);
	public List<SupportItem> getActiveItemList();
	public List<SupportItem> getActiveReportItemList();
	public List<SupportItem> getActiveProblemRecordItemList();
	public List<SupportItemActivity> getSupportItemActivityList(long itemId);
	public SupportItemActivity saveSupportItemActivity(SupportItemActivity supportItemActivity);
	public Page<SupportItem> getAdvSrcSupportItem(String advanceSearchSupportItem,int pageNumber);
	public List<SupportItem> getSupportItemForExcel(String advanceSearchSupportItem,String type);
}
