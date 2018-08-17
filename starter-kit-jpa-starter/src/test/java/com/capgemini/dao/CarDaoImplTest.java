package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.impl.CarDaoImpl;
import com.capgemini.dao.impl.EmployeeDaoImpl;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.PersonData;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarDaoImplTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CarDaoImpl carDao;

	@Autowired
	private EmployeeDaoImpl employeeDao;

	@Before
	public void setUp() {

		PersonData stefan = new PersonData("stefan", "batory");
		EmployeeEntity stefanEmpl = new EmployeeEntity().builder().withPerson(stefan).build();

		PersonData marian = new PersonData("marian", "nowak");
		List<CarEntity> listCars = new ArrayList<>();
		EmployeeEntity marianEmpl = new EmployeeEntity().builder().withPerson(marian).withCarKeeper(listCars).build();

		CarEntity opelCorsa = new CarEntity().builder().withBrand("Opel").withModel("Corsa").withType("Combi").build();
		CarEntity opelAstra = new CarEntity().builder().withBrand("Opel").withModel("Astra").withType("Van").build();
		CarEntity maluch = new CarEntity().builder().withBrand("Fiat").withModel("126P").withType("Van")
				.withEmployeeKeeper(Collections.singletonList(stefanEmpl)).build();

		carDao.save(opelCorsa);
		carDao.save(opelAstra);
		carDao.save(maluch);

		List<CarEntity> listCar = new ArrayList<>();
		listCar.add(maluch);
		stefanEmpl.setCarKeeper(listCar);
	}

	@Test
	public void shouldFindCarByCarKeeper() {

		// given

		// when
		List<CarEntity> foundCars = carDao.findCarByCarKeeper(1L);

		// then
		Assert.assertNotNull(foundCars);
		Assert.assertTrue(foundCars.size() == 1);
		Assert.assertFalse(foundCars.get(0).getListEmployeeKeeper().isEmpty());
	}

	@Test
	public void shouldNotFindCarByCarKeeperId2L() {

		// given

		// when
		List<CarEntity> foundCars = carDao.findCarByCarKeeper(2L);

		// then
		Assert.assertTrue(foundCars.size() == 0);
		Assert.assertTrue(foundCars.isEmpty());
	}

	@Test
	public void shouldFindCarsByTypeCombiAndBrandOpel() {

		// given
		final int expectedAmountOfCars = 1;
		final String combiType = "Combi";
		final String opelBrand = "Opel";

		// when
		List<CarEntity> foundCars = carDao.findCarByTypeAndBrand(combiType, opelBrand);

		// then
		Assert.assertNotNull(foundCars);
		Assert.assertTrue(foundCars.size() == expectedAmountOfCars);
		Assert.assertTrue(foundCars.get(0).getType().equals(combiType));
		Assert.assertTrue(foundCars.get(0).getBrand().equals(opelBrand));
	}

	@Test
	public void shouldNotFindCarsByTypeHatchbackAndBrandRenault() {

		// given
		final String hatchbackType = "Hatchback";
		final String renaultBrand = "Renault";

		// when
		List<CarEntity> foundCars = carDao.findCarByTypeAndBrand(hatchbackType, renaultBrand);

		// then
		Assert.assertTrue(foundCars.isEmpty());

	}

	@Test
	public void shouldFindCarByCarKeepera() {

		// given

		// when
		// List<CarEntity> all = carDao.findAll();
		// List<EmployeeEntity> allemp = employeeDao.findAll();
		List<CarEntity> foundCars = carDao.findCarByCarKeeper(1L);

		// then
		Assert.assertNotNull(foundCars);
		Assert.assertTrue(foundCars.size() == 1);
		Assert.assertFalse(foundCars.get(0).getListEmployeeKeeper().isEmpty());

	}

}
