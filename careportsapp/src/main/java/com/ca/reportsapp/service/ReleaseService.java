/**
 * 
 */
package com.ca.reportsapp.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.reportsapp.dao.domain.entity.Releases;

/**
 * @author Anupam Biswas
 * 2020-03-15 03:08:03.047
 */
@Transactional
@Service
public interface ReleaseService {
	
	public Page<Releases> findAllReleases(int pageNumber);
	public Page<Releases> getReleaseItemByRequest(String srcReleaseItem,int pageNumber);
	public Releases saveReleaseItem(Releases item);
	public void deleteReleaseItemById(long releaseItemId);
	public Releases getReleaseItemByID(long devItemId);
}
