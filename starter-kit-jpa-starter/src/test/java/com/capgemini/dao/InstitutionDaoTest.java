package com.capgemini.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
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

	@Test
	public void shouldFindCurrentEmployeeInInstitution() {

		// given
		final int expectedAmountOfEmployees = 1;

		PersonData stefan = new PersonData("stefan", "batory");
		EmployeeEntity stefanEmpl = new EmployeeEntity().builder().withPerson(stefan).build();
		employeeDaoImpl.save(stefanEmpl);
		AddressData ad = new AddressData().builder().withStreet("Dluga").withHouseNumber("12").withCity("Wroclaw")
				.withPostCode("64-254").build();
		InstitutionEntity institution = new InstitutionEntity().builder().withAddress(ad)
				.withListEmployee(Collections.singletonList(stefanEmpl)).build();
		institutionDaoImpl.save(institution);

		// when
		List<EmployeeEntity> listEmployee = institutionDaoImpl.findCurrentEmployee(1L);

		// then
		Assert.assertNotNull(listEmployee);
		Assert.assertTrue(listEmployee.size() == expectedAmountOfEmployees);

	}

}
