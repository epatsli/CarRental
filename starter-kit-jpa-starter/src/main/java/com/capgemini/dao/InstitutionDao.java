package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;

public interface InstitutionDao extends Dao<InstitutionEntity, Long> {

	List<EmployeeEntity> findCurrentEmployee(int idInstitution);

	List<EmployeeEntity> findCarKeeperInInstitution(int idCar, int idInstitution);
}
