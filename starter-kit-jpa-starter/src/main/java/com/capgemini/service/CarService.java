package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.types.CarTO;

public interface CarService {

	/**
	 * This method add car to database.
	 * 
	 * @param car
	 *            car to add
	 * @return car added
	 */
	CarTO addCar(CarTO car);

	/**
	 * This method delete car from database
	 * 
	 * @param car
	 *            car to delete
	 */
	void deleteCar(CarTO car);

	/**
	 * This method edit car in database.
	 * 
	 * @param car
	 *            car to edit
	 */
	void editCar(CarTO car);

	/**
	 * This method add car keeper to employee.
	 * 
	 * @param idCar
	 *            car which add to car keeper
	 * @param idEmployee
	 *            employee which have take care car
	 */
	void addCarKeeper(Long idCar, Long idEmployee);

	/**
	 * This method search car with type and brand.
	 * 
	 * @param type
	 *            car type
	 * @param brand
	 *            car brand
	 * @return list find cars
	 */
	List<CarTO> findByTypeAndBrand(String type, String brand);

	/**
	 * This method find cars search by car keeper.
	 * 
	 * @param idEmployee
	 *            index car keeper
	 * @return list of cars
	 */
	List<CarTO> findByCarKeeper(Long idEmployee);

	/**
	 * This method return cars which was rented more than ten distinct clients.
	 * 
	 * @return list of cars
	 */
	List<CarTO> findCarsRentedByMoreThenTenClients();

	/**
	 * This method return number of cars between two date.
	 * 
	 * @param startDate
	 *            first date
	 * @param endDate
	 *            second date
	 * @return number of cars
	 */
	int findNumberOfRentedCarsBetweenDates(LocalDate startDate, LocalDate endDate);

}
