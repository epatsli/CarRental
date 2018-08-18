package com.capgemini.service;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.types.CarTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarServiceTest {

	@Autowired
	private CarService carService;

	@Autowired
	private InstitutionService institutionService;

	@Autowired
	private EmployeeDao employeeDao;
	@PersistenceContext
	private EntityManager entityManager;

	// @Mock
	// private CarMapper carMapper;

	// @Mock
	// private CarDao carDaoMock;

	@Test
	public void shouldAddCarAndReturnAddedCar() {

		// given
		CarTO carTO = new CarTO().builder().withBrand("Opel").withModel("Corsa").withType("Combi").build();

		// when
		CarTO addedCar = carService.addCar(carTO);
		// then
		assertEquals("Opel", addedCar.getBrand());
		assertEquals("Combi", addedCar.getType());
		// Mockito.when(carDaoMock.findCarByTypeAndBrand(any(), any()));
	}

}
