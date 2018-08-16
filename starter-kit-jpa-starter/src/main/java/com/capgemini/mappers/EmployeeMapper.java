package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.domain.PersonData;
import com.capgemini.domain.PositionEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;
import com.capgemini.types.InstitutionTO;
import com.capgemini.types.PersonDataTO;
import com.capgemini.types.PositionTO;

public class EmployeeMapper {

	public static EmployeeTO toEmployeeTO(EmployeeEntity employeeEntity) {
		if (employeeEntity == null)
			return null;

		List<CarTO> carKeepers = CarMapper.map2TOs(employeeEntity.getCarKeeper());
		PersonDataTO person = PersonMapper.mapToTO(employeeEntity.getPerson());
		PositionTO position = PositionMapper.toPositionTO(employeeEntity.getPosition());
		InstitutionTO institutionTO = InstitutionMapper.toInstitutionTO(employeeEntity.getInstitutionEmployee());
		return new EmployeeTOBuilder().withIdEmployee(employeeEntity.getIdEmployee()).withPerson(person)
				.withPosition(position).withInstitutionEmployee(institutionTO).withCarKeeper(carKeepers).builder();

	}

	public static EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {
		if (employeeTO == null)
			return null;

		EmployeeEntity employeeEntity = new EmployeeEntity();
		PersonData person = PersonMapper.mapToEntity(employeeTO.getPerson());
		PositionEntity position = PositionMapper.toPositionEntity(employeeTO.getPosition());
		InstitutionEntity institution = InstitutionMapper.toInstitutionEntity(employeeTO.getInstitutionEmployee());
		List<CarEntity> carKeepers = CarMapper.map2Entities(employeeTO.getCarKeeper());

		employeeEntity.setPerson(person);
		employeeEntity.setPosition(position);
		employeeEntity.setInstitutionEmployee(institution);
		employeeEntity.setCarKeeper(carKeepers);
		return employeeEntity;
	}

	public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
	}

	public static List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toList());
	}

}
