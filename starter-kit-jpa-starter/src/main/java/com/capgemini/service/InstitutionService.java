package com.capgemini.service;

import java.util.List;

import com.capgemini.types.EmployeeTO;
import com.capgemini.types.InstitutionTO;

public interface InstitutionService {

	/**
	 * This method add institution to database.
	 * 
	 * @param institution
	 *            institution to add
	 * @return added institution
	 */
	InstitutionTO addInstitution(InstitutionTO institution);

	/**
	 * This method remove institution from database.
	 * 
	 * @param institution
	 *            institution to delete
	 */
	void deleteInstitution(InstitutionTO institution);

	/**
	 * This method edit data institution.
	 * 
	 * @param institution
	 *            institution to edit
	 * @return edit institution
	 */
	InstitutionTO editInstitution(InstitutionTO institution);

	/**
	 * This method add employee to institution.
	 * 
	 * @param idInstitution
	 *            index of institution
	 * @param idEmployee
	 *            index of employee
	 */
	void addEmployeeTOInstitution(Long idInstitution, Long idEmployee);

	/**
	 * This method delete employee from institution.
	 * 
	 * @param idEmployee
	 *            index of employee
	 */
	void deleteEmployeeWithInstitution(Long idEmployee);

	/**
	 * This method find all employee in institution.
	 * 
	 * @param idInstitution
	 *            index of institution
	 * @return list of employees in institution
	 */
	List<EmployeeTO> findAllEmployeeInIntitution(Long idInstitution);

	/**
	 * This method find all car keeper for car.
	 * 
	 * @param idInstitution
	 *            index of institution
	 * @param idCar
	 *            index of car
	 * @return list of employees
	 */
	List<EmployeeTO> findAllCarKeeperInInstitution(Long idInstitution, Long idCar);

}
