package com.capgemini.mappers;

import java.util.stream.Collectors;

import com.capgemini.domain.AuthorEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.types.AuthorTO;
import com.capgemini.types.InstitutionTO;
import com.capgemini.types.InstitutionTO.InstitutionTOBuilder;

public class InstitutionMapper {

	public static InstitutionTO toInstitutionTO(InstitutionEntity institutionEntity) {
		if (institutionEntity == null)
			return null;

		Set<AuthorTO> authorTOs = AuthorMapper.map2TOs(InstitutionEntity.getAuthors());
		return new InstitutionTOBuilder().withAuthors(authorTOs).withTitle(InstitutionEntity.getTitle())
				.withId(InstitutionEntity.getId()).build();

	}

	public static InstitutionEntity toInstitutionEntity(InstitutionTO InstitutionTO) {
		if (InstitutionTO == null)
			return null;
		InstitutionEntity InstitutionEntity = new InstitutionEntity();
		Set<AuthorEntity> authors = AuthorMapper.map2Entities(InstitutionTO.getAuthors());
		InstitutionEntity.setAuthors(authors);
		InstitutionEntity.setTitle(InstitutionTO.getTitle());
		return InstitutionEntity;
	}

	public static List<InstitutionTO> map2TOs(List<InstitutionEntity> InstitutionEntities) {
		return InstitutionEntities.stream().map(InstitutionMapper::toInstitutionTO).collect(Collectors.toList());
	}

	public static List<InstitutionEntity> map2Entities(List<InstitutionTO> InstitutionTOs) {
		return InstitutionTOs.stream().map(InstitutionMapper::toInstitutionEntity).collect(Collectors.toList());
	}

}
