package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.InstitutionDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;

@Repository
public class InstitutionDaoImpl extends AbstractDao<InstitutionEntity, Long> implements InstitutionDao {

	/**
	 * Returns list of current employees of the institution.
	 * 
	 * @param idInstitution
	 *            index institution
	 * @return List<EmployeeEntity> workers list
	 */
	@Override
	public List<EmployeeEntity> findCurrentEmployee(Long idInstitution) {

		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"SELECT emp FROM EmployeeEntity emp WHERE :idInstitution =emp.institutionEmployee.idInstitution ",
				EmployeeEntity.class);
		query.setParameter("idInstitution", idInstitution);
		return query.getResultList();
	}

	/**
	 * Returns list of current employees of the institution which take care car.
	 * 
	 * @param idCar
	 *            index car
	 * @param idInstitution
	 *            index institution
	 * @return List<EmployeeEntity> workers list
	 */
	@Override
	public List<EmployeeEntity> findCarKeeperInInstitution(Long idCar, Long idInstitution) {

		CarEntity car = entityManager.getReference(CarEntity.class, idCar);
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"SELECT emp FROM EmployeeEntity emp WHERE :idInstitution=emp.institutionEmployee.idInstitution AND :idCar MEMBER OF emp.carKeeper",
				EmployeeEntity.class);
		query.setParameter("idInstitution", idInstitution);
		query.setParameter("idCar", car);
		return query.getResultList();

	}

}
