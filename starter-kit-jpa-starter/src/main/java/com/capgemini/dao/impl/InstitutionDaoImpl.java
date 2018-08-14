package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

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

		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"SELECT * FROM EmployeeEntity emp WHERE emp.idInstitution=:idInstitution ", EmployeeEntity.class);
		query.setParameter("idInstitution", idInstitution);
		return query.getResultList();
	}

	@Override
	public List<EmployeeEntity> findCarKeeperInInstitution(int idCar, int idInstitution) {
		// TODO Auto-generated method stub

		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"SELECT * FROM EmployeeEntity emp JOIN emp.idCarEntity e WHERE e.idCar=:idCar AND emp.idInstitution=:idInstitution  ",
				EmployeeEntity.class);
		query.setParameter("idInstitution", idInstitution);
		query.setParameter("idCar", idCar);
		return query.getResultList();

	}

}
