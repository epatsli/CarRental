package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	/**
	 * Return list of employee
	 * 
	 * @param idInstitution
	 * @param idInstitution
	 * @param idInstitution
	 * @return the current result.
	 */
	List<EmployeeEntity> findCarKeeperByInstitution(Long idInstitution, Long idCar, Long idPoition);

}
