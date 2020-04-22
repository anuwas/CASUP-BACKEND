/**
 * 
 */
package com.ca.reportsapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ca.reportsapp.dao.DevItemDAO;
import com.ca.reportsapp.dao.DevSprintDAO;
import com.ca.reportsapp.dao.domain.entity.DevDailyScrumStatus;
import com.ca.reportsapp.dao.domain.entity.DevItem;
import com.ca.reportsapp.dao.domain.entity.DevSprint;
import com.ca.reportsapp.dao.repository.DevDailyScrumStatusRepository;
import com.ca.reportsapp.dto.DevItemSrcRequest;
import com.ca.reportsapp.service.DevtItemService;
import com.ca.reportsapp.service.helper.DevItemServiceHelper;
import com.google.gson.Gson;

/**
 * @author Anupam Biswas
 * 2020-01-12 00:59:19.214
 */
@Component
public class DevtItemServiceImpl implements DevtItemService{
	
	@Autowired
	DevItemDAO devItemDAO;
	
	@Autowired
	DevSprintDAO devSprintDAO;
	
	@Autowired
	Gson gson;
	
	@Autowired
	DevItemServiceHelper devItemServiceHelper;
	
	@Autowired
	DevDailyScrumStatusRepository devDailyScrumStatusRepository;

	@Override
	public Page<DevItem> findAllDevItem(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("itemCreatedTimestamp").descending());
		return devItemDAO.findAll(pageable);
	}

	@Override
	public Page<DevSprint> findAllDevSprint(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("sprintId").descending());
		return devSprintDAO.findAll(pageable);
	}

	@Override
	public Page<DevItem> getDevItemByRequest(String srcDevItem, int pageNumber) {
		DevItemSrcRequest srcDevItemAttributes = gson.fromJson(srcDevItem, DevItemSrcRequest.class);
		System.out.println(srcDevItem);
		Pageable pageable = PageRequest.of(pageNumber-1, 50);
		Page<DevItem> srcitem = devItemServiceHelper.retrieveDevItemByDTORequest(srcDevItemAttributes, pageable);
		
		return srcitem;
	}

	@Override
	public DevItem saveItem(DevItem item) {
		if(item.getParentItem()!=null && !item.getParentItem().equals("")) {
			long parentItem =  devItemDAO.findByItemNumber(item.getParentItem().trim()).get(0).getDevItemId();
			item.setItemParentId(parentItem);
		}
		
		return devItemDAO.save(item);
	}

	@Override
	public DevItem getItemByID(long devItemId) {
		Optional<DevItem> item = devItemDAO.findById(devItemId);
		if (!item.isPresent())
			System.out.println("item not found");

		return item.get();
	}

	@Override
	public void deleteItemById(long devItemId) {
		devItemDAO.deleteById(devItemId);
	}

	@Override
	public List<DevItem> findCurrentSprintItem(String currentSprint) {
		return devItemDAO.findByItemSprintName(currentSprint);
	}

	@Override
	public List<DevDailyScrumStatus> getDailyStatusByDevItem(String devItem) {
		return devDailyScrumStatusRepository.findByDevItem(devItem,Sort.by(Sort.Direction.DESC, "statusDate"));
	}

	@Override
	public DevDailyScrumStatus saveDailyStatus(DevDailyScrumStatus dailyStatus) {
		return devDailyScrumStatusRepository.save(dailyStatus);
	}

	@Override
	public DevDailyScrumStatus getItemStatuById(long statusId) {
		return devDailyScrumStatusRepository.findById(statusId).get();
	}

}
