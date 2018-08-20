package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.SearchCriteriaEntity;

public interface SearchCriteriaDao extends Dao<EmployeeEntity, Long> {

	/**
	 * This method find employees who work in institution.
	 * 
	 * @param idInstitution
	 *            index institution
	 * @return list of employees
	 */
	List<EmployeeEntity> findEmployeesByInstitution(Long idInstitution);

	/**
	 * This method find employees who take care specified car.
	 * 
	 * @param idCar
	 *            index car
	 * @return list of employees
	 */
	List<EmployeeEntity> findEmployeesByCar(Long idCar);

	/**
	 * This method find employees who have specified position.
	 * 
	 * @param idPosition
	 *            index position
	 * @return list of employees
	 */
	List<EmployeeEntity> findEmployeesByPosition(Long idPosition);

	/**
	 * This method find employees who work in specified institution, take care
	 * specified car and have specified position.
	 * 
	 * @param searchCriteria
	 * @return list of employees
	 */
	List<EmployeeEntity> findEmployeesByCriteria(SearchCriteriaEntity searchCriteria);

}
