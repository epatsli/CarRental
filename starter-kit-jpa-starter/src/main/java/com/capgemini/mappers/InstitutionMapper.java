package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.AddressData;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.domain.RentingCarEntity;
import com.capgemini.types.AddressDataTO;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.InstitutionTO;
import com.capgemini.types.InstitutionTO.InstitutionTOBuilder;
import com.capgemini.types.RentingCarTO;

public class InstitutionMapper {

	public static InstitutionTO toInstitutionTO(InstitutionEntity institution) {

		if (institution == null)
			return null;

		List<EmployeeTO> employeeTOs = EmployeeMapper.map2TOs(institution.getListEmployee());
		List<RentingCarTO> listInstitutionPickups = RentingCarMapper.map2TOs(institution.getListInstitutionPickup());
		List<RentingCarTO> listInstitutionReturn = RentingCarMapper.map2TOs(institution.getListInstitutionReturn());
		AddressDataTO address = AddressMapper.mapToTO(institution.getAddress());

		return new InstitutionTOBuilder().withIdInstitution(institution.getIdInstitution()).withAddress(address)
				.withEmail(institution.getEmail()).withPhoneNumber(institution.getPhoneNumber())
				.withListEmployee(employeeTOs).withListInstitutionPickup(listInstitutionPickups)
				.withListInstitutionReturn(listInstitutionReturn).build();

	}

	public static InstitutionEntity toInstitutionEntity(InstitutionTO institutionTO) {

		if (institutionTO == null)
			return null;

		InstitutionEntity institutionEntity = new InstitutionEntity();

		List<EmployeeEntity> employeeTOs = EmployeeMapper.map2Entities(institutionTO.getListEmployee());
		List<RentingCarEntity> listInstitutionPickups = RentingCarMapper
				.map2Entities(institutionTO.getListInstitutionPickup());
		List<RentingCarEntity> listInstitutionReturn = RentingCarMapper
				.map2Entities(institutionTO.getListInstitutionReturn());
		AddressData address = AddressMapper.mapToEntity(institutionTO.getAddress());

		institutionEntity.setAddress(address);
		institutionEntity.setEmail(institutionTO.getEmail());
		institutionEntity.setPhoneNumber(institutionTO.getPhoneNumber());
		institutionEntity.setListEmployee(employeeTOs);
		institutionEntity.setListInstitutionPickup(listInstitutionPickups);
		institutionEntity.setListInstitutionReturn(listInstitutionReturn);
		return institutionEntity;
	}

	public static List<InstitutionTO> map2TOs(List<InstitutionEntity> institutionEntities) {
		return institutionEntities.stream().map(InstitutionMapper::toInstitutionTO).collect(Collectors.toList());
	}

	public static List<InstitutionEntity> map2Entities(List<InstitutionTO> institutionTOs) {
		return institutionTOs.stream().map(InstitutionMapper::toInstitutionEntity).collect(Collectors.toList());
	}

}
