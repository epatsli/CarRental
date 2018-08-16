package com.capgemini.service;

import java.util.List;

import com.capgemini.types.CarTO;

public interface CarService {

	CarTO addCar(CarTO car);

	void deleteCar(CarTO car);

	CarTO editCar(CarTO car);

	CarTO addCarKeeper(Long idCar, Long idEmployee);

	List<CarTO> findByTypeAndBrand(String type, String brand);

	List<CarTO> findByCarKeeper(Long idEmployee);

}
