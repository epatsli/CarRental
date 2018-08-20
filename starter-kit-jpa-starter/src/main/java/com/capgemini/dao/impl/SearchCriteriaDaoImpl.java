package com.capgemini.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.SearchCriteriaDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.domain.PositionEntity;
import com.capgemini.domain.SearchCriteria;

@Repository
public class SearchCriteriaDaoImpl extends AbstractDao<EmployeeEntity, Long> implements SearchCriteriaDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.dao.SearchCriteriaDao#findEmployeesByInstitution(java.lang.
	 * Long)
	 */
	@Override
	public List<EmployeeEntity> findEmployeesByInstitution(Long idIndtitution) {
		InstitutionEntity institution = entityManager.getReference(InstitutionEntity.class, idIndtitution);
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("ELECT e FROM EmployeeEntity e WHERE institution =:institution", EmployeeEntity.class);
		query.setParameter("institution", institution);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.dao.SearchCriteriaDao#findEmployeesByPosition(java.lang.
	 * Long)
	 */
	@Override
	public List<EmployeeEntity> findEmployeesByPosition(Long idPosition) {
		PositionEntity position = entityManager.getReference(PositionEntity.class, idPosition);
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("SELECT e FROM EmployeeEntity e WHERE position =:position", EmployeeEntity.class);
		query.setParameter("position", position);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.dao.SearchCriteriaDao#findEmployeesByCar(java.lang.Long)
	 */
	@Override
	public List<EmployeeEntity> findEmployeesByCar(Long idCar) {
		CarEntity car = entityManager.getReference(CarEntity.class, idCar);
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("SELECT e FROM EmployeeEntity e WHERE :car MEMBER OF e.carKeeper", EmployeeEntity.class);
		query.setParameter("car", car);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.dao.SearchCriteriaDao#findEmployeesByCriteria(com.capgemini
	 * .domain.SearchCriteria)
	 */
	@Override
	public List<EmployeeEntity> findEmployeesByCriteria(SearchCriteria criteria) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT e FROM EmployeeEntity e WHERE ");

		if (criteria.getIdInstitution() != null) {
			stringBuilder.append("institution =:institution AND ");
			InstitutionEntity institution = entityManager.getReference(InstitutionEntity.class,
					criteria.getIdInstitution());
			parameters.put("institution", institution);
		}

		if (criteria.getIdCar() != null) {
			stringBuilder.append(":car MEMBER OF e.carKeeper AND ");
			CarEntity car = entityManager.getReference(CarEntity.class, criteria.getIdCar());
			parameters.put("car", car);
		}

		if (criteria.getIdInstitution() != null) {
			stringBuilder.append("position =:position");
			PositionEntity position = entityManager.getReference(PositionEntity.class, criteria.getIdPosition());
			parameters.put("position", position);
		}

		TypedQuery<EmployeeEntity> query = entityManager.createQuery(stringBuilder.toString(), EmployeeEntity.class);
		parameters.keySet().forEach(q -> query.setParameter(q, parameters.get(q)));
		return query.getResultList();
	}

}
