package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

	private final CarDao carDao;

	@Autowired
	public CarServiceImpl(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO addCar(CarTO car) {

		CarEntity carEntity = carDao.save(CarMapper.toCarEntity(car));
		return CarMapper.toCarTO(carEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCar(CarTO car) {

		carDao.delete(CarMapper.toCarEntity(car));
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO editCar(CarTO car) {

		CarEntity carEntity = carDao.update(CarMapper.toCarEntity(car));
		return CarMapper.toCarTO(carEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO addCarKeeper(Long idCar, Long idEmployee) {

		// fghfgh

		return null;
	}

	@Override
	public List<CarTO> findByTypeAndBrand(String type, String brand) {

		List<CarEntity> carsByTypeAndBrand = carDao.findCarByTypeAndBrand(type, brand);
		return CarMapper.map2TOs(carsByTypeAndBrand);
	}

	@Override
	public List<CarTO> findByCarKeeper(Long idEmployee) {

		List<CarEntity> carsByCarKeeper = carDao.findCarByCarKeeper(idEmployee);
		return CarMapper.map2TOs(carsByCarKeeper);
	}

}
