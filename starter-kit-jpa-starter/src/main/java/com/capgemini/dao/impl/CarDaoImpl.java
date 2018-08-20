package com.capgemini.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.dao.CarDao#findCarByTypeAndBrand(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<CarEntity> findCarByTypeAndBrand(String type, String brand) {

		TypedQuery<CarEntity> query = entityManager.createQuery(
				"SELECT car FROM CarEntity car WHERE upper(car.type) like concat(upper(:type), '%') AND upper(car.brand) like concat(upper(:brand), '%')",
				CarEntity.class);
		query.setParameter("type", type);
		query.setParameter("brand", brand);
		return query.getResultList();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.dao.CarDao#findCarByCarKeeper(java.lang.Long)
	 */
	@Override
	public List<CarEntity> findCarByCarKeeper(Long idEmployee) {

		EmployeeEntity employee = entityManager.getReference(EmployeeEntity.class, idEmployee);
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"SELECT car FROM CarEntity car WHERE :idEmployee MEMBER OF car.employeeKeeper ", CarEntity.class);
		query.setParameter("idEmployee", employee);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.dao.CarDao#findCarsRentedByMoreThenTenCustomers()
	 */
	@Override
	public List<CarEntity> findCarsRentedByMoreThenTenClients() {

		TypedQuery<CarEntity> query = entityManager.createQuery(
				"SELECT carEnt FROM CarEntity carEnt JOIN carEnt.RentingCarEntity c GROUP BY carEnt.listRentingCar list HAVING COUNT(DISTINCT list.ClientEntity.idClient)>=10",
				CarEntity.class);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.dao.CarDao#findNumberOfRentedCarsBetweenDates(java.time.
	 * LocalDate, java.time.LocalDate)
	 */
	@Override
	public int findNumberOfRentedCarsBetweenDates(LocalDate startDate, LocalDate endDate) {

		TypedQuery<CarEntity> query = entityManager.createQuery(
				"SELECT COUNT(rent) FROM RentedCarEntity rent WHERE rent.pickupDate BETWEEN :startDate and :endDate",
				CarEntity.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getMaxResults();
	}

}
