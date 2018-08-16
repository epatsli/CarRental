package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
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

	@Test
	public void fieldAnnotations() {
		// assert
		AssertAnnotations.assertField(CarEntity.class, "idCar");
		AssertAnnotations.assertField(CarEntity.class, "type");
		AssertAnnotations.assertField(CarEntity.class, "brand");
		AssertAnnotations.assertField(CarEntity.class, "model");
	}

	@Test
	public void shouldReturnCarByType() {

		carOne = new CarEntity.CarEntityBuilder("Van", "Opel", "Astra").withColor("black").withEngineCapacity(2000)
				.withMileage(20000).withEnginePower(120).withYear(2010)// .withListRentingCar(new
																		// List<RentingCarEntity>())
				.build();
		carDao.save(carOne);
		// given
		String type = "Combi";
		String brand = "Opel";

		// when
		List<CarEntity> result = carDao.findCarByTypeAndBrand(type, brand);

		// then
		assertEquals(1, result.size());
		CarEntity car = result.get(0);
		assertEquals(carOne.getEngine_capacity(), car.getEngine_capacity());
		assertEquals(carOne.getBrand(), car.getBrand());
		assertEquals(type, car.getType());
		assertEquals(carOne.getColor(), car.getColor());
		assertEquals(carOne.getMileage(), car.getMileage());
		assertEquals(carOne.getEnginePower(), car.getEnginePower());
		assertEquals(carOne.getYear(), car.getYear());
	}

}
