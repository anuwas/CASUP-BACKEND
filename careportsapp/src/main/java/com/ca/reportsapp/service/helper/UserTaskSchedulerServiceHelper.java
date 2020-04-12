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

import com.ca.reportsapp.dao.domain.entity.UserTaskScheduler;
import com.ca.reportsapp.dto.UserTaskSchedulerRequest;

/**
 * @author Anupam Biswas
 * 2020-04-10 22:41:24.260
 */
@Component
public class UserTaskSchedulerServiceHelper {
	
	@Autowired
	EntityManager em;
	
	public Page<UserTaskScheduler> retrieveReleaseItemByDTORequest(UserTaskSchedulerRequest filter, Pageable pageable) {

        CriteriaBuilder builder =  em.getCriteriaBuilder();
        CriteriaQuery<UserTaskScheduler> criteria = builder.createQuery(UserTaskScheduler.class);
        Root<UserTaskScheduler> supportItemRoot = criteria.from(UserTaskScheduler.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        if (!filter.getTaskStatus().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("taskStatus"), filter.getTaskStatus())); 
		}
        
        if (!filter.getPriority().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("priority"), filter.getPriority())); 
		}
        
        if(filter.getFollowUpTo()!=null && !filter.getFollowUpTo().equals("")) {
        	predicates.add(builder.like(supportItemRoot.get("followUpTo"), "%"+filter.getFollowUpTo()+"%"));
        }
        
        if(filter.getTaskScheduledStartDate()!=null && filter.getTaskScheduledStartDate()!=null) {		
        	predicates.add(builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("taskScheduledDate"), filter.getTaskScheduledStartDate()), builder.lessThanOrEqualTo(supportItemRoot.get("taskScheduledDate"), filter.getTaskScheduledEndDate())));
        }
        

        criteria.where(builder.and(predicates.toArray( new Predicate[predicates.size()])));

        criteria.orderBy(builder.desc(supportItemRoot.get("taskScheduledDate")));

        // This query fetches the SupItem as per the Page Limit
        List<UserTaskScheduler> result = em.createQuery(criteria).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();

        // Create Count Query
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<UserTaskScheduler> supportItemRootRootCount = countQuery.from(UserTaskScheduler.class);
        countQuery.select(builder.count(supportItemRootRootCount)).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        // Fetches the count of all SupItem as per given criteria
        Long count = em.createQuery(countQuery).getSingleResult();

        Page<UserTaskScheduler> result1 = new PageImpl<>(result, pageable, count);
       
        return result1;
    }

}
