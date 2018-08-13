package com.capgemini.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.InstitutionDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;

@Repository
public class InstitutionDaoImpl extends AbstractDao<InstitutionEntity, Long> implements InstitutionDao {

	@Override
	public void addInstitution() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeInstitution(int idInstitution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editInstitution(int idInstitution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEmployeeToInstitute(int idEmployee, int idInstitution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEmployeeWithInstitute(int idEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeEntity> findCurrentEmployee(int idInstitution) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findCarKeeperInInstitution(int idCar, int idInstitution) {
		// TODO Auto-generated method stub
		return null;
	}

}
