/**
 * 
 */
package com.ca.reportsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ca.reportsapp.dao.DevItemDAO;
import com.ca.reportsapp.dao.DevSprintDAO;
import com.ca.reportsapp.dao.domain.entity.DevItem;
import com.ca.reportsapp.dao.domain.entity.DevSprint;
import com.ca.reportsapp.dto.DevItemSrcRequest;
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

}
