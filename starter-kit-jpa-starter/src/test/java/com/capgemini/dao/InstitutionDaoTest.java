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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.impl.CarDaoImpl;
import com.capgemini.dao.impl.EmployeeDaoImpl;
import com.capgemini.dao.impl.InstitutionDaoImpl;
import com.capgemini.domain.AddressData;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.domain.PersonData;

@ActiveProfiles("hsql")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InstitutionDaoTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private InstitutionDaoImpl institutionDaoImpl;

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;

	@Autowired
	private CarDaoImpl carDao;

	@Before
	public void setUp() {

		PersonData stefan = new PersonData("Stefan", "Batory");
		EmployeeEntity stefanEmpl = new EmployeeEntity().builder().withPerson(stefan).build();
		employeeDaoImpl.save(stefanEmpl);

		PersonData jan = new PersonData("Jan", "Maria");
		EmployeeEntity janEmpl = new EmployeeEntity().builder().withPerson(jan).build();
		employeeDaoImpl.save(janEmpl);

		PersonData edmund = new PersonData("Edmund", "Maly");
		EmployeeEntity edmundEmpl = new EmployeeEntity().builder().withPerson(edmund).build();
		employeeDaoImpl.save(edmundEmpl);

		List<EmployeeEntity> listEmployee = new ArrayList<>();
		listEmployee.add(stefanEmpl);
		listEmployee.add(edmundEmpl);

		AddressData address = new AddressData().builder().withStreet("Dluga").withHouseNumber("12").withCity("Wroclaw")
				.withPostCode("64-254").build();
		InstitutionEntity institution = new InstitutionEntity().builder().withAddress(address)
				.withListEmployee(listEmployee).build();
		institutionDaoImpl.save(institution);

		stefanEmpl.setInstitutionEmployee(institution);
		edmundEmpl.setInstitutionEmployee(institution);

		AddressData addressInst = new AddressData().builder().withStreet("Mala").withHouseNumber("81/2")
				.withCity("Krzyz").withPostCode("61-471").build();
		InstitutionEntity institutionSecond = new InstitutionEntity().builder().withAddress(addressInst).build();
		institutionDaoImpl.save(institutionSecond);

		CarEntity maluch = new CarEntity().builder().withBrand("Fiat").withModel("126P").withType("Van")
				.withEmployeeKeeper(Collections.singletonList(edmundEmpl)).build();
		carDao.save(maluch);

		List<CarEntity> listCar = new ArrayList<>();
		listCar.add(maluch);
		edmundEmpl.setCarKeeper(listCar);

		CarEntity opelAstra = new CarEntity().builder().withBrand("Opel").withModel("Astra").withType("Van").build();
		carDao.save(opelAstra);

	}

	@Test
	public void shouldFindCarKeeperInInstitution() {

		// given

		// when
		List<EmployeeEntity> listEmployee = institutionDaoImpl.findCarKeeperInInstitution(1L, 1L);

		// then
		Assert.assertNotNull(listEmployee);
		Assert.assertEquals(1, listEmployee.size());
		Assert.assertEquals("Edmund", listEmployee.get(0).getPerson().getFirstName());

	}

	@Test
	public void shouldCanFindCarKeeperInInstitution1L() {

		// given

		// when
		List<EmployeeEntity> listEmployee = institutionDaoImpl.findCarKeeperInInstitution(2L, 1L);

		// then
		Assert.assertTrue(listEmployee.isEmpty());

	}

	@Test
	public void shouldFindCurrentEmployeeInInstitution() {

		// given
		List<EmployeeEntity> listEmployee = new ArrayList<>();

		// when
		listEmployee = institutionDaoImpl.findCurrentEmployee(1L);

		// then
		Assert.assertNotNull(listEmployee);
		Assert.assertEquals(2, listEmployee.size());
		Assert.assertEquals("Stefan", listEmployee.get(0).getPerson().getFirstName());
		Assert.assertEquals("Batory", listEmployee.get(0).getPerson().getLastName());
		Assert.assertEquals("Edmund", listEmployee.get(1).getPerson().getFirstName());
		Assert.assertEquals("Maly", listEmployee.get(1).getPerson().getLastName());
		Assert.assertTrue(listEmployee.size() == 2);
	}

	@Test
	public void shouldCantFindCurrentEmployeeInInstitution() {

		// given

		// when
		List<EmployeeEntity> listEmployee = institutionDaoImpl.findCurrentEmployee(2L);

		// then
		Assert.assertTrue(listEmployee.isEmpty());
		Assert.assertEquals(0, listEmployee.size());
		Assert.assertTrue(listEmployee.size() == 0);

	}

}
