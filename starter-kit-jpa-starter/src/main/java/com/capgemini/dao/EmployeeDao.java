package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	List<EmployeeEntity> findCarKeeperByInstitution(Long idInstitution, Long idCar, Long idPoition);

}
