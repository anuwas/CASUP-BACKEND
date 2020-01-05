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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.ca.reportsapp.dao.domain.entity.SupportItem;
import com.ca.reportsapp.dao.repository.SupportItemRepository;
import com.ca.reportsapp.dto.AdvanceSearchSupportItem;

/**
 * @author Anupam Biswas
 * 2020-01-05 17:28:50.114
 */
@Component
public class SupportItemServiceHelper {
	
	@Autowired
	SupportItemRepository supportItemRepository;
	
	@Autowired
	EntityManager em;
	
	public List<SupportItem> retrieveAdvSrcSupportItemPage(AdvanceSearchSupportItem filter) {
		return supportItemRepository.findAll(new Specification<SupportItem>() {

			@Override
			public Predicate toPredicate(Root<SupportItem> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				
				List<Predicate> predicates = new ArrayList<>();
				
				/*
				 * if (filter.getItemCreatedDate() != null) {
				 * predicates.add(cb.equal(root.get("designation"), filter.getDesignation())); }
				 */

				  if (filter.getApplicationName() != null) {
				  predicates.add(cb.equal(root.get("applicationName"), filter.getApplicationName())); }
				 
				  if (filter.getItemStatus() != null) {
					  predicates.add(cb.equal(root.get("itemStatus"), filter.getItemStatus())); }
				
				return cb.and(predicates.toArray(new Predicate[0]));
			}
			
		});
	}
	
	
	public Page<SupportItem> retrieveAdvSrcSupportItemPage(AdvanceSearchSupportItem filter, Pageable pageable) {

        CriteriaBuilder builder =  em.getCriteriaBuilder();
        CriteriaQuery<SupportItem> criteria = builder.createQuery(SupportItem.class);
        Root<SupportItem> supportItemRoot = criteria.from(SupportItem.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

		/*
		 * predicates.add(builder.equal(booksRoot.get("id"), params.getRequestId()));
		 * 
		 * predicates.add(builder.like(builder.lower(booksRoot.get("name")), "%" +
		 * params.getName().toLowerCase() + "%"));
		 */
        if (filter.getItemNumber() != 0) {
			  predicates.add(builder.equal(supportItemRoot.get("itemNumber"), filter.getItemNumber())); 
		}
        
        if (filter.getApplicationName() != null) {
			  predicates.add(builder.equal(supportItemRoot.get("applicationName"), filter.getApplicationName())); 
		}
        
        if (filter.getItemStatus() != null) {
			  predicates.add(builder.equal(supportItemRoot.get("itemStatus"), filter.getItemStatus())); 
		}

        criteria.where(builder.and(predicates.toArray( new Predicate[predicates.size()])));

        criteria.orderBy(builder.desc(supportItemRoot.get("itemCreatedTimestamp")));

        // This query fetches the SupItem as per the Page Limit
        List<SupportItem> result = em.createQuery(criteria).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();

        // Create Count Query
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<SupportItem> supportItemRootRootCount = countQuery.from(SupportItem.class);
        countQuery.select(builder.count(supportItemRootRootCount)).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        // Fetches the count of all SupItem as per given criteria
        Long count = em.createQuery(countQuery).getSingleResult();

        Page<SupportItem> result1 = new PageImpl<>(result, pageable, count);
        return result1;
    }
}
