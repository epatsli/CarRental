package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;

public interface InstitutionDao extends Dao<InstitutionEntity, Long> {

	void addInstitution();

	void removeInstitution(int idInstitution);

	// jakie?
	void editInstitution(int idInstitution);

	void addEmployeeToInstitute(int idEmployee, int idInstitution);

	void removeEmployeeWithInstitute(int idEmployee);

	List<EmployeeEntity> findCurrentEmployee(int idInstitution);

	List<EmployeeEntity> findCarKeeperInInstitution(int idCar, int idInstitution);
}
