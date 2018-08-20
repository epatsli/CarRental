package com.capgemini.service;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.RentingCarMapper;
import com.capgemini.service.impl.CarServiceImpl;
import com.capgemini.types.CarTO;

//@RunWith(SpringRunner.class)

@ActiveProfiles("hsql")
@SpringBootTest
@Transactional
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

	// @PersistenceContext
	// private EntityManager entityManager;

	@Mock
	private CarMapper carMapperMock;

	@Mock
	private CarDao carDaoMock;

	@InjectMocks
	private CarServiceImpl carService;

	@Test
	public void should() {
		CarEntity carEntity = new CarEntity().builder().withBrand("Opel").withModel("Corsa").withType("Combi").build();
		CarTO carTO = new CarTO().builder().withBrand("Opel").withModel("Corsa").withType("Combi").build();
		Mockito.when(carDaoMock.save(carEntity)).thenReturn(carEntity);
		Mockito.when(carService.addCar(carTO)).thenReturn(carTO);

		Mockito.verify(carDaoMock, times(1)).save(carEntity);
	}

	@Test
	public void shouldFindCarByTypeAndBrand() {

		// given
		CarEntity carEntity = new CarEntity().builder().withBrand("Opel").withModel("Corsa").withType("Combi").build();
		List<CarEntity> list = new ArrayList<>();
		list.add(carEntity);
		CarTO carTO = new CarTO().builder().withBrand("Opel").withModel("Corsa").withType("Combi").build();
		List<CarTO> listTO = new ArrayList<>();
		listTO.add(carTO);

		// when
		Mockito.when(carDaoMock.findCarByTypeAndBrand("Combi", "Opel")).thenReturn(list);
		CarMapper objMapper = Mockito.mock(CarMapper.class);
		RentingCarMapper objMapp = Mockito.mock(RentingCarMapper.class);
		// Mockito.when(carMapperMock.map2Entities(listTO)).thenReturn(list);
		// Mockito.when(carMapperMock.map2TOs(list)).thenReturn(listTO);
		// Mockito.when(carMapperMock.toCarEntity(carTO)).thenReturn(carEntity);
		// Mockito.when(carMapperMock.toCarTO(carEntity)).thenReturn(carTO);

		// Mockito.when(carMapperMock.map2TOs(list)).thenReturn(listTO);
		carService.findByTypeAndBrand("Combi", "Opel");
		// CarTO addedCar = carService.addCar(carTO);

		// then
		Mockito.verify(carDaoMock, times(1)).findCarByTypeAndBrand("Combi", "Opel");
	}

	// Mockito.when(carDaoMock.findCarByTypeAndBrand(any(), any()));

}
