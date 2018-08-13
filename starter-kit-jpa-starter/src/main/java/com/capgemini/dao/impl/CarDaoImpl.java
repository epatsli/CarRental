package com.capgemini.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public void addCar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCar(int idCar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editCar(int idCar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCarKeeper(int idCar, int idEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CarEntity> findCarByTypeAndBrand(String type, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> findCarByCarKeeper(int idEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

}
