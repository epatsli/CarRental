package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;

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

		TypedQuery<CarEntity> query = entityManager
				.createQuery("SELECT car FROM CarEntity car WHERE car.carKeeper=:idEmployee ", CarEntity.class);
		query.setParameter("idEmployee", idEmployee);
		return query.getResultList();
	}

}
