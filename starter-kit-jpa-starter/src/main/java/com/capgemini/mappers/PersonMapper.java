package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.PersonData;
import com.capgemini.types.PersonDataTO;

public class PersonMapper {

	public static PersonDataTO mapToTO(PersonData peronData) {

		return new PersonDataTO(peronData.getFirstName(), peronData.getLastName(), peronData.getDataOfBirth());
	}

	public static PersonData mapToEntity(PersonDataTO peronDataTO) {

		return new PersonData(peronDataTO.getFirstName(), peronDataTO.getLastName(), peronDataTO.getDataOfBirth());
	}

	public static List<PersonDataTO> mapToTO(List<PersonData> personData) {
		return personData.stream().map(PersonMapper::mapToTO).collect(Collectors.toList());
	}

	public static List<PersonData> mapToEntity(List<PersonDataTO> personDataTOs) {
		return personDataTOs.stream().map(PersonMapper::mapToEntity).collect(Collectors.toList());
	}

}
