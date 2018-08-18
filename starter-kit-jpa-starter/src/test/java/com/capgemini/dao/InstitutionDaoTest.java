package com.capgemini.dao;

import java.util.ArrayList;
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

import com.capgemini.dao.impl.EmployeeDaoImpl;
import com.capgemini.dao.impl.InstitutionDaoImpl;
import com.capgemini.domain.AddressData;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.domain.PersonData;

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

	}

	@Test
	public void shouldFindCurrentEmployeeInInstitution() {

		// given

		// when
		List<EmployeeEntity> listEmployee = institutionDaoImpl.findCurrentEmployee(1L);

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
	public void shouldFindCurKeeperInInstitution() {

		// given
		final int expectedAmountOfEmployees = 1;

		// when
		List<EmployeeEntity> listEmployee = institutionDaoImpl.findCarKeeperInInstitution(1L, 1L);

		// then
		Assert.assertNotNull(listEmployee);
		Assert.assertTrue(listEmployee.size() == expectedAmountOfEmployees);

	}

}
