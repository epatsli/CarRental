package com.capgemini.service;

import java.util.List;

import com.capgemini.types.EmployeeTO;
import com.capgemini.types.InstitutionTO;

public interface InstitutionService {

	InstitutionTO addInstitution(InstitutionTO institution);

	void deleteInstitution(InstitutionTO institution);

	InstitutionTO editInstitution(InstitutionTO institution);

	InstitutionTO addEmployeeTOInstitution(InstitutionTO Institution, EmployeeTO employee);

	void deleteEmployeeWithInstitution(Long idEmployee);

	List<EmployeeTO> findAllEmployeeInIntitution(Long idInstitution);

	List<EmployeeTO> findAllCarKeeperInInstitution(Long idInstitution, Long idCar);

}
