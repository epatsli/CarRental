package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.InstitutionDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.mappers.InstitutionMapper;
import com.capgemini.service.InstitutionService;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.InstitutionTO;

@Service
@Transactional(readOnly = true)
public class InstitutionServiceImpl implements InstitutionService {

	private final InstitutionDao institutionDao;
	private final EmployeeDao employeeDao;

	@Autowired
	public InstitutionServiceImpl(InstitutionDao institutionDao, EmployeeDao employeeDao) {
		this.institutionDao = institutionDao;
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional(readOnly = false)
	public InstitutionTO addInstitution(InstitutionTO institution) {
		InstitutionEntity institutionEntity = institutionDao.save(InstitutionMapper.toInstitutionEntity(institution));
		return InstitutionMapper.toInstitutionTO(institutionEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteInstitution(InstitutionTO institution) {
		institutionDao.delete(InstitutionMapper.toInstitutionEntity(institution));
	}

	@Override
	@Transactional(readOnly = false)
	public InstitutionTO editInstitution(InstitutionTO institution) {
		InstitutionEntity institutionEntity = institutionDao.update(InstitutionMapper.toInstitutionEntity(institution));
		return InstitutionMapper.toInstitutionTO(institutionEntity);

	}

	@Override
	@Transactional(readOnly = false)
	public void addEmployeeTOInstitution(Long idInstitution, Long idEmployee) {

		InstitutionEntity institutionEntity = institutionDao.findOne(idInstitution);
		EmployeeEntity employeeEntity = employeeDao.findOne(idEmployee);
		List<EmployeeEntity> employess = institutionEntity.getListEmployee();
		employess.add(employeeEntity);
		institutionEntity.setListEmployee(employess);
		institutionDao.save(institutionEntity);

	}

	@Override
	@Transactional(readOnly = false)
	public void deleteEmployeeWithInstitution(Long idEmployee) {

		EmployeeEntity employeeEntity = employeeDao.findOne(idEmployee);
		InstitutionEntity institutionEntity = employeeEntity.getInstitutionEmployee();
		employeeEntity.setInstitutionEmployee(null);
		List<EmployeeEntity> employees = institutionEntity.getListEmployee();
		employees.remove(employeeEntity);
		institutionEntity.setListEmployee(employees);
		institutionDao.save(institutionEntity);

	}

	@Override
	public List<EmployeeTO> findAllEmployeeInIntitution(Long idInstitution) {
		List<EmployeeEntity> employees = institutionDao.findCurrentEmployee(idInstitution);
		return EmployeeMapper.map2TOs(employees);
	}

	@Override
	public List<EmployeeTO> findAllCarKeeperInInstitution(Long idInstitution, Long idCar) {
		List<EmployeeEntity> carKeepersInInstitution = institutionDao.findCarKeeperInInstitution(idCar, idInstitution);
		return EmployeeMapper.map2TOs(carKeepersInInstitution);
	}

}
