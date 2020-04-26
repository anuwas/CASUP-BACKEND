package com.ca.reportsapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ca.reportsapp.dao.ReleasesDAO;
import com.ca.reportsapp.dao.domain.entity.Releases;
import com.ca.reportsapp.dto.ReleaseItemRequest;
import com.ca.reportsapp.service.ReleaseService;
import com.ca.reportsapp.service.helper.ReleaseServiceHelper;
import com.google.gson.Gson;

/**
 * @author Anupam Biswas
 * 2020-03-15 03:17:11.396
 */
@Component
public class ReleaseServiceImpl implements ReleaseService{
	
	@Autowired
	ReleasesDAO releasesDAO;
	
	@Autowired
	Gson gson;
	
	@Autowired
	ReleaseServiceHelper releaseServiceHelper;

	@Override
	public Page<Releases> findAllReleases(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 50, Sort.by("uatRelaseDate").descending());
		return releasesDAO.findAll(pageable);
	}

	@Override
	public Page<Releases> getReleaseItemByRequest(String srcReleaseItem, int pageNumber) {
		ReleaseItemRequest releaseItemRequest =  gson.fromJson(srcReleaseItem, ReleaseItemRequest.class);
		Pageable pageable = PageRequest.of(pageNumber-1, 50);
		Page<Releases> srcitem = releaseServiceHelper.retrieveReleaseItemByDTORequest(releaseItemRequest, pageable);
		
		return srcitem;
	}

	@Override
	public Releases saveReleaseItem(Releases item) {
		return releasesDAO.save(item);
	}

	@Override
	public void deleteReleaseItemById(long releaseItemId) {
		releasesDAO.deleteById(releaseItemId);
		
	}

	@Override
	public Releases getReleaseItemByID(long releaseItemId) {
		return releasesDAO.findById(releaseItemId).get();
	}

}
