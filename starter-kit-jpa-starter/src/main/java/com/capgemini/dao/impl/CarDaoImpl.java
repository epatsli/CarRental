package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public void addCar(int idCar, String type, String brand) {
		// TODO Auto-generated method stub

		Query query = entityManager.createQuery("INSERT INTO CarEntity (idCar, type, brand) " + " VALUES(?,?,?)");
		query.setParameter(1, idCar);
		query.setParameter(2, type);
		query.setParameter(3, brand);
		query.executeUpdate();

	}

	@Override
	public void removeCar(int idCar) {
		// TODO Auto-generated method stub

		Query query = entityManager.createQuery("DELETE FROM EntityCar car WHERE idCar=: idCar");
		// int deletedCar =
		query.setParameter("idCar", idCar).executeUpdate();
	}

	@Override
	public void editCar(int idCar, String brand, int engine_capacity, int mileage) {
		// TODO Auto-generated method stub

		String hql = "UPDATE CarEntity ET brand = :brand , engine_capacity = :engine_capacity, mileage = :mileage WHERE idCar=:idCar)";
		Query query = entityManager.createQuery(hql);
		query.setParameter("idCar", idCar);
		query.setParameter("brand", brand);
		query.setParameter("engine_capacity", engine_capacity);
		query.setParameter("mileage", mileage);
		query.executeUpdate();

	}

	@Override
	public void addCarKeeper(int idCar, int idEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CarEntity> findCarByTypeAndBrand(String type, String brand) {
		// TODO Auto-generated method stub

		TypedQuery<CarEntity> query = entityManager.createQuery(
				"SELECT * FROM CarEntity car WHERE car.type=:type upper(car.type) like concat(upper(:type), '%' AND car.brand=:brand upper(car.brand) like concat(upper(:brand), '%'",
				CarEntity.class);
		query.setParameter("type", type);
		query.setParameter("brand", brand);
		return query.getResultList();

	}

	@Override
	public List<CarEntity> findCarByCarKeeper(int idEmployee) {
		// TODO Auto-generated method stub

		TypedQuery<CarEntity> query = entityManager
				.createQuery("SELECT * FROM CarEntity car WHERE car.carKeeper=:idEmployee ", CarEntity.class);
		query.setParameter("idEmployee", idEmployee);
		return query.getResultList();
	}

}
