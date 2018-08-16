package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.AddressData;
import com.capgemini.domain.AddressData.AddressDataBuilder;
import com.capgemini.types.AddressDataTO;
import com.capgemini.types.AddressDataTO.AddressDataTOBuilder;

public class AddressMapper {

	public static AddressDataTO mapToTO(AddressData addressData) {

		return new AddressDataTOBuilder().withStreet(addressData.getStreet())
				.withHouseNumber(addressData.getNumberHous()).withCity(addressData.getCity())
				.withPostCode(addressData.getPostCode()).build();
	}

	public static AddressData mapToEntity(AddressDataTO addressDataTO) {

		return new AddressDataBuilder().withStreet(addressDataTO.getStreet())
				.withHouseNumber(addressDataTO.getHouseNumber()).withCity(addressDataTO.getCity())
				.withPostCode(addressDataTO.getPostCode()).build();
	}

	public static List<AddressDataTO> mapToTO(List<AddressData> addressData) {
		return addressData.stream().map(AddressMapper::mapToTO).collect(Collectors.toList());
	}

	public static List<AddressData> mapToEntity(List<AddressDataTO> addressDataTOs) {
		return addressDataTOs.stream().map(AddressMapper::mapToEntity).collect(Collectors.toList());
	}
}
