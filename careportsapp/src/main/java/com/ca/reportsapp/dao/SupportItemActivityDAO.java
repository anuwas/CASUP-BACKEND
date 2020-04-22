package com.ca.reportsapp.dao;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.ca.reportsapp.dao.domain.entity.SupportItemActivity;
import com.ca.reportsapp.dao.repository.SupportItemActivityRepository;

public interface SupportItemActivityDAO extends SupportItemActivityRepository{
	List<SupportItemActivity> findAllByitemId(long itemId,Sort sort);
}
