package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	List<CarEntity> findCarByTypeAndBrand(String type, String brand);

	List<CarEntity> findCarByCarKeeper(Long idEmployee);

}
