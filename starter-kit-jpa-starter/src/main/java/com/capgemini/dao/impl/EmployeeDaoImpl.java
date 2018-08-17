package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

	@Override
	public List<EmployeeEntity> findCarKeeperByInstitution(Long idInstitution, Long idCar, Long idPoition) {

		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"SELECT e FROM EmployeeEntity e WHERE :idInstitution = e.institution OR :idCar MEMBER OF e.cars OR :idPoition == idPoition",
				EmployeeEntity.class);
		query.setParameter("institution", idInstitution);
		query.setParameter("car", idCar);
		query.setParameter("idPoition", idPoition);
		return query.getResultList();
	}

}
