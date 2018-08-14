package com.capgemini.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.domain.AuthorEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;

public class CarMapper {

	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null)
			return null;

		return new CarTOBuilder(carEntity.getIdCar(), carEntity.getType(), carEntity.getBrand(), carEntity.getModel())
				.withColor(carEntity.getColor()).withEngine_capacity(carEntity.getEngine_capacity())
				.withEngine_power(carEntity.getEngine_power()).withMileage(carEntity.getMileage())
				.withYear(carEntity.getYear()).build();

	}

	public static CarEntity toCarEntity(CarTO carTO) {

		if (carTO == null)
			return null;

		CarEntity carEntity = new CarEntity();

		Set<AuthorEntity> authors = AuthorMapper.map2Entities(carTO.getAuthors());

		carEntity.setAuthors(authors);

		carEntity.setTitle(carTO.getTitle());

		return carEntity;
	}

	public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
	}

	public static List<CarEntity> map2Entities(List<CarTO> carTOs) {
		return carTOs.stream().map(CarMapper::toCarEntity).collect(Collectors.toList());
	}

}
