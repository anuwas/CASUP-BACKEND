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

import com.ca.reportsapp.dao.domain.entity.Releases;
import com.ca.reportsapp.dto.ReleaseItemRequest;

/**
 * @author Anupam Biswas
 * 2020-03-15 12:47:08.489
 */
@Component
public class ReleaseServiceHelper {
	
	@Autowired
	EntityManager em;
	
	public Page<Releases> retrieveReleaseItemByDTORequest(ReleaseItemRequest filter, Pageable pageable) {

        CriteriaBuilder builder =  em.getCriteriaBuilder();
        CriteriaQuery<Releases> criteria = builder.createQuery(Releases.class);
        Root<Releases> supportItemRoot = criteria.from(Releases.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        if (!filter.getApplicationName().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("applicationName"), filter.getApplicationName())); 
		}

        /*
        if (filter.getItemNumber()!=null && !filter.isTask() && !filter.isSubTask()) {
			predicates.add(builder.equal(supportItemRoot.get("itemNumber"), filter.getItemNumber())); 
		}
        
        if(filter.getItemNumber()!=null && filter.isSubTask() && !filter.isTask()) {
        	predicates.add(builder.equal(supportItemRoot.get("parentItem"), filter.getItemNumber())); 
        }
        
		
		
		if(filter.isTask() && !filter.isSubTask()) {
			predicates.add(builder.isNull(supportItemRoot.get("parentItem"))); 
		}
		
		if(!filter.isTask() && filter.isSubTask()) {
			predicates.add(builder.isNotNull(supportItemRoot.get("parentItem"))); 
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
         */
       

        criteria.where(builder.and(predicates.toArray( new Predicate[predicates.size()])));

        criteria.orderBy(builder.desc(supportItemRoot.get("itemCreatedTimestamp")));

        // This query fetches the SupItem as per the Page Limit
        List<Releases> result = em.createQuery(criteria).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();

        // Create Count Query
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<Releases> supportItemRootRootCount = countQuery.from(Releases.class);
        countQuery.select(builder.count(supportItemRootRootCount)).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        // Fetches the count of all SupItem as per given criteria
        Long count = em.createQuery(countQuery).getSingleResult();

        Page<Releases> result1 = new PageImpl<>(result, pageable, count);
       
        return result1;
    }

}
