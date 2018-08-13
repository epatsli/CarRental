package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	void addCar();

	void removeCar(int idCar);

	void editCar(int idCar);

	void addCarKeeper(int idCar, int idEmployee);

	List<CarEntity> findCarByTypeAndBrand(String type, String brand);

	List<CarEntity> findCarByCarKeeper(int idEmployee);

}
