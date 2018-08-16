package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.ClientEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.domain.RentingCarEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.ClientTO;
import com.capgemini.types.InstitutionTO;
import com.capgemini.types.RentingCarTO;
import com.capgemini.types.RentingCarTO.RentingCarTOBuilder;

public class RentingCarMapper {

	public static RentingCarTO toRentingCarTO(RentingCarEntity rentingCarEntity) {

		if (rentingCarEntity == null)
			return null;

		InstitutionTO institutionPickup = InstitutionMapper.toInstitutionTO(rentingCarEntity.getInstitutionPickup());
		InstitutionTO institutionReturn = InstitutionMapper.toInstitutionTO(rentingCarEntity.getInstitutionReturn());
		ClientTO clientRented = ClientMapper.toClientTO(rentingCarEntity.getClientRented());
		CarTO car = CarMapper.toCarTO(rentingCarEntity.getCar());

		return new RentingCarTOBuilder().withIdRenting(rentingCarEntity.getIdRenting())
				.withPickupDate(rentingCarEntity.getPickupDate()).withReturnDate(rentingCarEntity.getReturnDate())
				.withPrice(rentingCarEntity.getPrice()).withInstitutionPickup(institutionPickup)
				.withInstitutionReturn(institutionReturn).withClientRented(clientRented).withCar(car).build();

	}

	public static RentingCarEntity toRentingCarEntity(RentingCarTO rentingCarTO) {

		if (rentingCarTO == null)
			return null;

		RentingCarEntity rentingCarEntity = new RentingCarEntity();

		InstitutionEntity institutionPickup = InstitutionMapper
				.toInstitutionEntity(rentingCarTO.getInstitutionPickup());
		InstitutionEntity institutionReturn = InstitutionMapper
				.toInstitutionEntity(rentingCarTO.getInstitutionReturn());
		ClientEntity clientRented = ClientMapper.toClientEntity(rentingCarTO.getClientRented());
		CarEntity car = CarMapper.toCarEntity(rentingCarTO.getCar());

		rentingCarEntity.setPickupDate(rentingCarTO.getPickupDate());
		rentingCarEntity.setReturnDate(rentingCarTO.getReturnDate());
		rentingCarEntity.setPrice(rentingCarTO.getPrice());
		rentingCarEntity.setInstitutionPickup(institutionPickup);
		rentingCarEntity.setInstitutionReturn(institutionReturn);
		rentingCarEntity.setClientRented(clientRented);
		rentingCarEntity.setCar(car);

		return rentingCarEntity;
	}

	public static List<RentingCarTO> map2TOs(List<RentingCarEntity> rentingCarEntities) {
		return rentingCarEntities.stream().map(RentingCarMapper::toRentingCarTO).collect(Collectors.toList());
	}

	public static List<RentingCarEntity> map2Entities(List<RentingCarTO> rentingCarTOs) {
		return rentingCarTOs.stream().map(RentingCarMapper::toRentingCarEntity).collect(Collectors.toList());
	}

}
