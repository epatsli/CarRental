package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;

public interface InstitutionDao extends Dao<InstitutionEntity, Long> {

	List<EmployeeEntity> findCurrentEmployee(Long idInstitution);

	List<EmployeeEntity> findCarKeeperInInstitution(Long idCar, Long idInstitution);
}
