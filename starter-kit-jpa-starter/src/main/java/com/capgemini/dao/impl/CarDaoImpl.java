package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public List<CarEntity> findCarByTypeAndBrand(String type, String brand) {

		TypedQuery<CarEntity> query = entityManager.createQuery(
				"SELECT car FROM CarEntity car WHERE upper(car.type) like concat(upper(:type), '%' AND upper(car.brand) like concat(upper(:brand), '%'",
				CarEntity.class);
		query.setParameter("type", type);
		query.setParameter("brand", brand);
		return query.getResultList();

	}

	@Override
	public List<CarEntity> findCarByCarKeeper(int idEmployee) {

		EmployeeEntity employee = entityManager.getReference(EmployeeEntity.class, idEmployee);
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"SELECT car FROM CarEntity car WHERE idEmployee member of car.carKeeper ", CarEntity.class);
		query.setParameter("idEmployee", employee);
		return query.getResultList();
	}

}
