package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.SearchCriteriaEntity;
import com.capgemini.types.EmployeeTO;

public interface SearchCriteriaService {

	/**
	 * This method return employees which meet the search criteria.
	 * 
	 * @param searchCriteria
	 *            search criteria
	 * @return list of employees
	 */
	List<EmployeeTO> findEmployeesByAllCriteria(SearchCriteriaEntity searchCriteria);
}
