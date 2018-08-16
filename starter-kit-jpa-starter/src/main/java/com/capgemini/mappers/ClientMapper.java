package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.AddressData;
import com.capgemini.domain.ClientEntity;
import com.capgemini.domain.PersonData;
import com.capgemini.domain.RentingCarEntity;
import com.capgemini.types.AddressDataTO;
import com.capgemini.types.ClientTO;
import com.capgemini.types.ClientTO.ClientTOBuilder;
import com.capgemini.types.PersonDataTO;
import com.capgemini.types.RentingCarTO;

public class ClientMapper {

	public static ClientTO toClientTO(ClientEntity clientEntity) {

		if (clientEntity == null)
			return null;

		PersonDataTO personDataTO = PersonMapper.mapToTO(clientEntity.getPerson());
		AddressDataTO address = AddressMapper.mapToTO(clientEntity.getAddress());
		List<RentingCarTO> rentingCarTOs = RentingCarMapper.map2TOs(clientEntity.getListRentingCars());

		return new ClientTOBuilder().withIdClient(clientEntity.getIdClient()).withPersonDataTO(personDataTO)
				.withEmail(clientEntity.getEmail()).withCreditCardNumber(clientEntity.getCreditCardNumber())
				.withAddress(address).withPhoneNumber(clientEntity.getPhoneNumber()).withListRentingCars(rentingCarTOs)
				.build();
	}

	public static ClientEntity toClientEntity(ClientTO clientTO) {

		if (clientTO == null)
			return null;

		ClientEntity clientEntity = new ClientEntity();

		AddressData address = AddressMapper.mapToEntity(clientTO.getAddress());
		PersonData personData = PersonMapper.mapToEntity(clientTO.getPerson());
		List<RentingCarEntity> rentingCar = RentingCarMapper.map2Entities(clientTO.getListRentingCars());

		clientEntity.setPerson(personData);
		clientEntity.setAddress(address);
		clientEntity.setEmail(clientTO.getEmail());
		clientEntity.setPhoneNumber(clientTO.getPhoneNumber());
		clientEntity.setCreditCardNumber(clientTO.getCreditCardNumber());
		clientEntity.setListRentingCars(rentingCar);
		return clientEntity;

	}

	public static List<ClientTO> map2TOs(List<ClientEntity> clientEntities) {
		return clientEntities.stream().map(ClientMapper::toClientTO).collect(Collectors.toList());
	}

	public static List<ClientEntity> map2Entities(List<ClientTO> clientTOs) {
		return clientTOs.stream().map(ClientMapper::toClientEntity).collect(Collectors.toList());
	}

}
