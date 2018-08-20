package com.capgemini.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.domain.CarEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	/**
	 * Returns a list of employees due to brand and type.
	 * 
	 * @param type
	 *            searched car type
	 * @param brand
	 *            searched car brand
	 * @return List<CarEntity> cars list
	 */
	List<CarEntity> findCarByTypeAndBrand(String type, String brand);

	/**
	 * Returns the car's guardian's cars.
	 * 
	 * @param idEmployee
	 *            index guardian's cars
	 * @return List<CarEntity> cars list
	 */
	List<CarEntity> findCarByCarKeeper(Long idEmployee);

	/**
	 * This method return cars which was rented by more than ten distinct
	 * clients.
	 * 
	 * @return car list
	 */
	List<CarEntity> findCarsRentedByMoreThenTenClients();

	/**
	 * 
	 * This method return number of renting cars between dates.
	 * 
	 * @param startDate
	 *            beginning of searched period
	 * @param endDate
	 *            end of searched period
	 * @return number of renting cars
	 */
	int findNumberOfRentedCarsBetweenDates(LocalDate startDate, LocalDate endDate);

}
