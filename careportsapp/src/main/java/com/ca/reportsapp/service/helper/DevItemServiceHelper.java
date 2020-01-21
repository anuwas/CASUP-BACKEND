/**
 * 
 */
package com.ca.reportsapp.service.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ca.reportsapp.dao.domain.entity.DevItem;
import com.ca.reportsapp.dto.DevItemSrcRequest;

/**
 * @author Anupam Biswas
 * 2020-01-12 01:47:31.025
 */
@Component
public class DevItemServiceHelper {
	
	@Autowired
	EntityManager em;
	
	public Page<DevItem> retrieveDevItemByDTORequest(DevItemSrcRequest filter, Pageable pageable) {

        CriteriaBuilder builder =  em.getCriteriaBuilder();
        CriteriaQuery<DevItem> criteria = builder.createQuery(DevItem.class);
        Root<DevItem> supportItemRoot = criteria.from(DevItem.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (filter.getItemNumber()!=null) {
			predicates.add(builder.equal(supportItemRoot.get("itemNumber"), filter.getItemNumber())); 
		}
        
		
		
		if(filter.isTask() && !filter.isSubTask()) {
			predicates.add(builder.isNull(supportItemRoot.get("parentItem"))); 
		}
		
		if(!filter.isTask() && filter.isSubTask()) {
			predicates.add(builder.isNotNull(supportItemRoot.get("parentItem"))); 
		}
        
        
        
        if (!filter.getApplicationName().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("applicationName"), filter.getApplicationName())); 
		}
        
        if (!filter.getItemStatus().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("itemStatus"), filter.getItemStatus())); 
		}
        
        if (!filter.getItemSprintName().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("itemSprintName"), filter.getItemSprintName())); 
		}
        
        if (!filter.getItemType().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("itemType"), filter.getItemType())); 
		}
        
        if (!filter.getDeveloperName().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("developerName"), filter.getDeveloperName())); 
		}
        
        if (!filter.getProjectName().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("projectName"), filter.getProjectName())); 
		}
        
        if (filter.isRefined()) {
			  predicates.add(builder.equal(supportItemRoot.get("isRefined"), "Y")); 
		}
        
       

        criteria.where(builder.and(predicates.toArray( new Predicate[predicates.size()])));

        criteria.orderBy(builder.desc(supportItemRoot.get("itemCreatedTimestamp")));

        // This query fetches the SupItem as per the Page Limit
        List<DevItem> result = em.createQuery(criteria).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();

        // Create Count Query
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<DevItem> supportItemRootRootCount = countQuery.from(DevItem.class);
        countQuery.select(builder.count(supportItemRootRootCount)).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        // Fetches the count of all SupItem as per given criteria
        Long count = em.createQuery(countQuery).getSingleResult();

        Page<DevItem> result1 = new PageImpl<>(result, pageable, count);
        return result1;
    }
}
