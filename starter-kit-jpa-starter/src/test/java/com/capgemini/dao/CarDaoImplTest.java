package com.capgemini.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.BeforeClass;
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

	private static CarEntity car1;
	private static CarEntity car2;
	private static EmployeeEntity employee;
	private static InstitutionEntity institution;
	private static PositionEntity position;

	@BeforeClass
	public static void init() {
		position = new PositionEntity("Manager");
		institution = new InstitutionEntity("Poznan", "2", "Glika", "62-030", "swsw", "451455");
		employee = new EmployeeEntity("Jan", "Kowalski", new Date(), institution, position);
		car2 = new CarEntity.CarEntityBuilder().withBrand("Renault").withCarType("Combi").withEmployee(employee)
				.withEngineCapacity(1500).withMileage(30000).withPower(100).withProductionYear(2014).withColor("red")
				.withRentals(new HashSet<RentalEntity>()).build();
	}

	@Before
	public void setup() {
		// carDao.deleteAll();
		List<CarEntity> cars = carDao.findAll();
		for (CarEntity car : cars) {
			carDao.delete(car.getIdCar());
		}
		carDao.save(car1);
		carDao.save(car2);
	}

	@Test
	public void shouldReturnCarByType() {

		// given
		String type = "Combi";
		String brand = "Opel";

		// when
		List<CarEntity> result = carDao.findCarByTypeAndBrand(type, brand);

		// then
		assertEquals(1, result.size());
		CarEntity car = result.get(0);
		assertEquals(car2.getEngineCapacity(), car.getEngineCapacity());
		assertEquals(car2.getBrandName(), car.getBrandName());
		assertEquals(type, car.getCarType());
		assertEquals(car2.getColor(), car.getColor());
		assertEquals(car2.getMileage(), car.getMileage());
		assertEquals(car2.getPower(), car.getPower());
		assertEquals(car2.getProductionYear(), car.getProductionYear());
	}

}
