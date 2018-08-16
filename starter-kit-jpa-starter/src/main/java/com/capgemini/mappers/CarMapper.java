package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.CarEntity.CarEntityBuilder;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.RentingCarTO;

public class CarMapper {

	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null)
			return null;
		List<RentingCarTO> RentingCarTOs = RentingCarMapper.map2TOs(carEntity.getListRentingCar());
		List<EmployeeTO> employeeKeepers = EmployeeMapper.map2TOs(carEntity.getListEmployeeKeeper());

		EntityManager entityManager;

		return new CarTOBuilder().withType(carEntity.getType()).withBrand(carEntity.getBrand())
				.withModel(carEntity.getModel()).withColor(carEntity.getColor())
				.withEngineCapacity(carEntity.getEngineCapacity()).withEnginePower(carEntity.getEnginePower())
				.withMileage(carEntity.getMileage()).withYear(carEntity.getYear()).withListRentingCar(RentingCarTOs)
				.withEmployeeKeeper(employeeKeepers).builder();
	}

	public static CarEntity toCarEntity(CarTO carTO) {

		if (carTO == null)
			return null;

		return new CarEntityBuilder().withType(carTO.getType()).withBrand(carTO.getBrand()).withModel(carTO.getModel())
				.withColor(carTO.getColor()).withEngineCapacity(carTO.getEngine_capacity())
				.withEnginePower(carTO.getEnginePower()).withMileage(carTO.getMileage()).withYear(carTO.getYear())
				.build();

	}

	public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
	}

	public static List<CarEntity> map2Entities(List<CarTO> carTOs) {
		return carTOs.stream().map(CarMapper::toCarEntity).collect(Collectors.toList());
	}

}
