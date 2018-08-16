package com.capgemini.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.impl.CarDaoImpl;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.domain.PositionEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarDaoImplTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CarDaoImpl carDao;

	private static CarEntity carOne;
	private static CarEntity carTwo;
	private static EmployeeEntity employee;
	private static InstitutionEntity institution;
	private static PositionEntity position;

}
