package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	void addCar(int idCar, String type, String brand);

	void removeCar(int idCar);

	void editCar(int idCar, String brand, int engine_capacity, int mileage);

	void addCarKeeper(int idCar, int idEmployee);

	List<CarEntity> findCarByTypeAndBrand(String type, String brand);

	List<CarEntity> findCarByCarKeeper(int idEmployee);

}
