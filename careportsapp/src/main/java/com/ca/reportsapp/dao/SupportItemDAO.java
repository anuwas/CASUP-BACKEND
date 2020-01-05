package com.ca.reportsapp.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ca.reportsapp.dao.domain.entity.SupportItem;
import com.ca.reportsapp.dao.repository.SupportItemRepository;

public interface SupportItemDAO extends SupportItemRepository{
	Page<SupportItem> findAll(Pageable pageable);
	@Query("SELECT t FROM SupportItem t where t.itemStatus not in  :names and t.cronicalReport = :report") 
	List<SupportItem> findByitemStatusNotInAndcronicalReportIn(@Param("names") List<String> names,@Param("report") String report);
	Page<SupportItem> findByitemNumber(Pageable pageable,long itemNumber);
	List<SupportItem> findBycronicalReport(String report);
}
