package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.dao.SearchCriteriaDao;
import com.capgemini.domain.SearchCriteriaEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.SearchCriteriaService;
import com.capgemini.types.EmployeeTO;

public class SearchCriteriaServiceImpl implements SearchCriteriaService {

	private SearchCriteriaDao searchCriteriaDao;

	@Autowired
	public SearchCriteriaServiceImpl(SearchCriteriaDao searchCriteriaDao) {
		this.searchCriteriaDao = searchCriteriaDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.service.SearchCriteriaService#findEmployeesByAllCriteria(
	 * com.capgemini.domain.SearchCriteria)
	 */
	@Override
	public List<EmployeeTO> findEmployeesByAllCriteria(SearchCriteriaEntity search) {

		return EmployeeMapper.map2TOs(searchCriteriaDao.findEmployeesByCriteria(search));

	}

}
