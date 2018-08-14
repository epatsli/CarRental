package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.CarEntity.CarEntityBuilder;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;

public class CarMapper {

	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null)
			return null;

		return new CarTOBuilder(carEntity.getType(), carEntity.getBrand(), carEntity.getModel())
				.withColor(carEntity.getColor()).withEngine_capacity(carEntity.getEngine_capacity())
				.withEngine_power(carEntity.getEngine_power()).withMileage(carEntity.getMileage())
				.withYear(carEntity.getYear()).build();
	}

	public static CarEntity toCarEntity(CarTO carTO) {

		if (carTO == null)
			return null;

		return new CarEntityBuilder(carTO.getType(), carTO.getBrand(), carTO.getModel()).withColor(carTO.getColor())
				.withEngine_capacity(carTO.getEngine_capacity()).withEngine_power(carTO.getEngine_power())
				.withMileage(carTO.getMileage()).withYear(carTO.getYear()).build();

	}

	public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
	}

	public static List<CarEntity> map2Entities(List<CarTO> carTOs) {
		return carTOs.stream().map(CarMapper::toCarEntity).collect(Collectors.toList());
	}

}
