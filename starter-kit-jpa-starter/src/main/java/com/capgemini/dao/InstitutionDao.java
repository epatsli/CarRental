package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;

public interface InstitutionDao extends Dao<InstitutionEntity, Long> {

	/**
	 * Returns list of current employees of the institution.
	 * 
	 * @param idInstitution
	 *            index institution
	 * @return List<EmployeeEntity> workers list
	 */
	List<EmployeeEntity> findCurrentEmployee(Long idInstitution);

	/**
	 * Returns list of current employees of the institution which take care car.
	 * 
	 * @param idCar
	 *            index car
	 * @param idInstitution
	 *            index institution
	 * @return List<EmployeeEntity> workers list
	 */
	List<EmployeeEntity> findCarKeeperInInstitution(Long idCar, Long idInstitution);
}
