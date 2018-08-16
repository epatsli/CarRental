package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.PositionEntity;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.PositionTO;
import com.capgemini.types.PositionTO.PositionTOBuilder;

public class PositionMapper {

	public static PositionTO toPositionTO(PositionEntity positionEntity) {
		if (positionEntity == null)
			return null;

		List<EmployeeTO> employeeTOs = EmployeeMapper.map2TOs(positionEntity.getListEmployee());
		return new PositionTOBuilder().withIdPosition(positionEntity.getIdPosition())
				.withNamePosition(positionEntity.getNamePosition()).withListEmployee(employeeTOs).build();
	}

	public static PositionEntity toPositionEntity(PositionTO positionTO) {
		if (positionTO == null)
			return null;

		PositionEntity positionEntity = new PositionEntity();
		List<EmployeeEntity> employees = EmployeeMapper.map2Entities(positionTO.getListEmployee());
		positionEntity.setListEmployee(employees);
		positionEntity.setNamePosition(positionTO.getNamePosition());
		return positionEntity;
	}

	public static List<PositionTO> map2TOs(List<PositionEntity> positionEntities) {
		return positionEntities.stream().map(PositionMapper::toPositionTO).collect(Collectors.toList());
	}

	public static List<PositionEntity> map2Entities(List<PositionTO> positionTOs) {
		return positionTOs.stream().map(PositionMapper::toPositionEntity).collect(Collectors.toList());
	}

}
