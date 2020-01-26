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
	
	public List<SupportItem> retrieveAdvSrcSupportItemForExcell(AdvanceSearchSupportItem filter,String type) {
		return supportItemRepository.findAll(new Specification<SupportItem>() {

			@Override
			public Predicate toPredicate(Root<SupportItem> supportItemRoot, CriteriaQuery<?> criteria,
					CriteriaBuilder builder) {
				
				List<Predicate> predicates = new ArrayList<>();
				
				/*
				 * if (filter.getItemCreatedDate() != null) {
				 * predicates.add(cb.equal(root.get("designation"), filter.getDesignation())); }
				 

				  if (!filter.getApplicationName().equals("All")) {
				  predicates.add(cb.equal(root.get("applicationName"), filter.getApplicationName())); }
				 
				  if (!filter.getItemStatus().equals("All")) {
					  predicates.add(cb.equal(root.get("itemStatus"), filter.getItemStatus())); }
				  */
				
				  if(filter.isOpneDate() && filter.isCloseDate()) {		
			        	predicates.add(builder.or(builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemToDate())), 
			        			builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemToDate()))));
			        }
			        
			        
			        if(filter.isOpneDate() && !filter.isCloseDate()) {
			        	predicates.add(builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemToDate())));
			        }
			        
			        if(!filter.isOpneDate() && filter.isCloseDate()) {
			        	predicates.add(builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemToDate())));
			        }
			        
			        if (filter.getItemNumber() != 0) {
						  predicates.add(builder.equal(supportItemRoot.get("itemNumber"), filter.getItemNumber())); 
					}
			        
			        if (!filter.getApplicationName().equals("All")) {
						  predicates.add(builder.equal(supportItemRoot.get("applicationName"), filter.getApplicationName())); 
					}
			        
			        if (!filter.getItemStatus().equals("All")) {
						  predicates.add(builder.equal(supportItemRoot.get("itemStatus"), filter.getItemStatus())); 
					}
			        
			        if (filter.isBounce()) {
						  predicates.add(builder.greaterThan(supportItemRoot.get("itemStatus"), 0)); 
					}
			        
			        if (!filter.getItemType().equals("All")) {
						  predicates.add(builder.equal(supportItemRoot.get("itemType"), filter.getItemType())); 
					}
			        
			        if (!filter.getItemAssigned().equals("All")) {
						  predicates.add(builder.equal(supportItemRoot.get("itemAssigned"), filter.getItemAssigned())); 
					}
			        
			        if (!filter.getSla().equals("All")) {
			        	switch(filter.getSla())	{
			        	case "NonAged":
			        		predicates.add(builder.equal(supportItemRoot.get("aged"), "N")); 
			        		break;
			        	case "Aged":
			        		predicates.add(builder.equal(supportItemRoot.get("aged"), "Y")); 
			        		break;
			        	case "Primary":
			        		predicates.add(builder.equal(supportItemRoot.get("primarySlaBreached"), "Y")); 
			        		break;
			        	case "Secondary":
			        		predicates.add(builder.equal(supportItemRoot.get("secondarySlaBreached"), "Y")); 
			        		break;
			        	case "Tertiary":
			        		predicates.add(builder.equal(supportItemRoot.get("tertirySlaBreached"), "Y")); 
			        		break;
			        	}
					}
			        

			        criteria.where(builder.and(predicates.toArray( new Predicate[predicates.size()])));

			        criteria.orderBy(builder.desc(supportItemRoot.get("itemCreatedTimestamp")));

				
				return builder.and(predicates.toArray(new Predicate[0]));
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
        /*
         * Mysql so jali it dosent suppot inclusive between
        if(filter.isOpneDate() && filter.isCloseDate()) {		
        	predicates.add(builder.or(builder.between(supportItemRoot.get("itemCreatedDate"), filter.getItemFromDate(), filter.getItemToDate()), 
        					builder.between(supportItemRoot.get("itemCloseDate"), filter.getItemFromDate(), filter.getItemToDate())));		
        }
        
        if(filter.isOpneDate() && !filter.isCloseDate()) {
        	predicates.add(builder.between(supportItemRoot.get("itemCreatedDate"), filter.getItemFromDate(), filter.getItemToDate()));
        }
        
        if(!filter.isOpneDate() && filter.isCloseDate()) {
        	predicates.add(builder.between(supportItemRoot.get("itemCloseDate"), filter.getItemFromDate(), filter.getItemToDate()));
        }
        */
        
        if(filter.isOpneDate() && filter.isCloseDate()) {		
        	predicates.add(builder.or(builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemToDate())), 
        			builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemToDate()))));
        }
        
        
        if(filter.isOpneDate() && !filter.isCloseDate()) {
        	predicates.add(builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCreatedDate"), filter.getItemToDate())));
        }
        
        if(!filter.isOpneDate() && filter.isCloseDate()) {
        	predicates.add(builder.and(builder.greaterThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemFromDate()), builder.lessThanOrEqualTo(supportItemRoot.get("itemCloseDate"), filter.getItemToDate())));
        }
        
        if (filter.getItemNumber() != 0) {
			  predicates.add(builder.equal(supportItemRoot.get("itemNumber"), filter.getItemNumber())); 
		}
        
        if (!filter.getApplicationName().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("applicationName"), filter.getApplicationName())); 
		}
        
        if (!filter.getItemStatus().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("itemStatus"), filter.getItemStatus())); 
		}
        
        if (filter.isBounce()) {
			  predicates.add(builder.greaterThan(supportItemRoot.get("itemStatus"), 0)); 
		}
        
        if (!filter.getItemType().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("itemType"), filter.getItemType())); 
		}
        
        if (!filter.getItemAssigned().equals("All")) {
			  predicates.add(builder.equal(supportItemRoot.get("itemAssigned"), filter.getItemAssigned())); 
		}
        
        if (!filter.getSla().equals("All")) {
        	switch(filter.getSla())	{
        	case "NonAged":
        		predicates.add(builder.equal(supportItemRoot.get("aged"), "N")); 
        		break;
        	case "Aged":
        		predicates.add(builder.equal(supportItemRoot.get("aged"), "Y")); 
        		break;
        	case "Primary":
        		predicates.add(builder.equal(supportItemRoot.get("primarySlaBreached"), "Y")); 
        		break;
        	case "Secondary":
        		predicates.add(builder.equal(supportItemRoot.get("secondarySlaBreached"), "Y")); 
        		break;
        	case "Tertiary":
        		predicates.add(builder.equal(supportItemRoot.get("tertirySlaBreached"), "Y")); 
        		break;
        	}
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
