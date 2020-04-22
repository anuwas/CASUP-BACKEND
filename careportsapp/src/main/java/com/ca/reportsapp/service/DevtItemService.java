/**
 * 
 */
package com.ca.reportsapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.reportsapp.dao.domain.entity.DevDailyScrumStatus;
import com.ca.reportsapp.dao.domain.entity.DevItem;
import com.ca.reportsapp.dao.domain.entity.DevSprint;
/**
 * @author Anupam Biswas
 * 2020-01-12 00:59:04.518
 */

@Transactional
@Service
public interface DevtItemService {
	public Page<DevItem> findAllDevItem(int pageNumber);
	public List<DevItem> findCurrentSprintItem(String currentSprint);
	public Page<DevSprint> findAllDevSprint(int pageNumber);
	public Page<DevItem> getDevItemByRequest(String srcDevItem,int pageNumber); 
	public DevItem saveItem(DevItem item);
	public DevItem getItemByID(long devItemId);
	public void deleteItemById(long devItemId);
	public List<DevDailyScrumStatus> getDailyStatusByDevItem(String devItem);
	public DevDailyScrumStatus saveDailyStatus(DevDailyScrumStatus dailyStatus);
	public DevDailyScrumStatus getItemStatuById(long statusId);
	
}
