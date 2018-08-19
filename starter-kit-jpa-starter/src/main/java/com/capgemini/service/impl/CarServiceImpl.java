package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

	private final CarDao carDao;
	private final EmployeeDao employeeDao;

	@Autowired
	public CarServiceImpl(CarDao carDao, EmployeeDao employeeDao) {
		this.carDao = carDao;
		this.employeeDao = employeeDao;
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
	public void editCar(CarTO car) {

		CarEntity carEntity = carDao.update(CarMapper.toCarEntity(car));
		CarMapper.toCarTO(carEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void addCarKeeper(Long idCar, Long idEmployee) {

		List<EmployeeEntity> employees = (carDao.findOne(idCar)).getListEmployeeKeeper();
		employees.add(employeeDao.findOne(idEmployee));
		(carDao.findOne(idCar)).setListEmployeeKeeper(employees);
		carDao.save(carDao.findOne(idCar));

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
