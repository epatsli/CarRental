package com.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LoggingTest {
	private static final Logger log = LoggerFactory.getLogger(LoggingTest.class);
	// LOGGER log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private CarDao carDao;

	private EntityManagerFactory emf;

	@Before
	public void init() {
		emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		CarEntity opelCorsa = new CarEntity().builder().withBrand("Opel").withModel("Corsa").withType("Combi").build();
		CarEntity opelAstra = new CarEntity().builder().withBrand("Opel").withModel("Astra").withType("Van").build();
		CarEntity maluch = new CarEntity().builder().withBrand("Fiat").withModel("126P").withType("Van").build();

		carDao.save(opelCorsa);
		carDao.save(opelAstra);
		carDao.save(maluch);
	}

	@After
	public void close() {
		emf.close();
	}

	@Test
	public void shouldShowLogging() {

		log.info("..... select ......");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query q = em.createQuery("SELECT car FROM CarEntity car  WHERE car.idCar=:idCar", CarEntity.class);
		q.setParameter("idCar", 1L);
		q.getSingleResult();

		em.getTransaction().commit();
		em.close();
	}
}
