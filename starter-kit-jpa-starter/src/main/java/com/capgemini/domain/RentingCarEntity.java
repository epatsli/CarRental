package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.exception.IncorrectParameterException;

/**
 * This class maps renting cars tables.
 *
 */
@Entity
@Table(name = "RENTINGCARS")
public class RentingCarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRenting;

	@Column(name = "pickupDate", nullable = false)
	private LocalDate pickupDate;

	@Column(name = "returnDate")
	private LocalDate returnDate;

	@Column(name = "price")
	private double price;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idInstitutionPickup", nullable = false)
	private InstitutionEntity institutionPickup;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idInstitutionReturn")
	private InstitutionEntity institutionReturn;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idClient", nullable = false)
	private ClientEntity clientRented;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCar", nullable = false)
	private CarEntity car;

	/**
	 * No-argument constructor
	 */
	public RentingCarEntity() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public RentingCarEntity(RentingCarEntityBuilder builder) {
		this.idRenting = builder.idRenting;
		this.pickupDate = builder.pickupDate;
		this.returnDate = builder.returnDate;
		this.price = builder.price;
		this.institutionPickup = builder.institutionPickup;
		this.institutionReturn = builder.institutionReturn;
		this.clientRented = builder.clientRented;
		this.car = builder.car;
	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public RentingCarEntityBuilder builder() {
		return new RentingCarEntityBuilder();
	}

	public Long getIdRenting() {
		return idRenting;
	}

	public void setIdRenting(Long idRenting) {
		this.idRenting = idRenting;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public InstitutionEntity getInstitutionPickup() {
		return institutionPickup;
	}

	public void setInstitutionPickup(InstitutionEntity institutionPickup) {
		this.institutionPickup = institutionPickup;
	}

	public InstitutionEntity getInstitutionReturn() {
		return institutionReturn;
	}

	public void setInstitutionReturn(InstitutionEntity institutionReturn) {
		this.institutionReturn = institutionReturn;
	}

	public ClientEntity getClientRented() {
		return clientRented;
	}

	public void setClientRented(ClientEntity clientRented) {
		this.clientRented = clientRented;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class RentingCarEntityBuilder {
		private Long idRenting;
		private LocalDate pickupDate;
		private LocalDate returnDate;
		private double price;
		private InstitutionEntity institutionPickup;
		private InstitutionEntity institutionReturn;
		private ClientEntity clientRented;
		private CarEntity car;

		/**
		 * No-argument constructor
		 */
		public RentingCarEntityBuilder() {
		}

		/**
		 * 
		 * This method set index renting.
		 * 
		 * @param idRenting
		 *            index renting
		 * @return new object with index
		 */
		public RentingCarEntityBuilder withIdRenting(Long idRenting) {
			this.idRenting = idRenting;
			return this;
		}

		/**
		 * This method set pickup date
		 * 
		 * @param pickupDate
		 *            date when car was take
		 * @return new object with pickup date
		 */
		public RentingCarEntityBuilder withPickupDate(LocalDate pickupDate) {
			this.pickupDate = pickupDate;
			return this;
		}

		/**
		 * This method set institution pickup
		 * 
		 * @param institutionPickup
		 *            place where take car
		 * @return new object with institution pickup
		 */
		public RentingCarEntityBuilder withInstitutionPickup(InstitutionEntity institutionPickup) {
			this.institutionPickup = institutionPickup;
			return this;
		}

		/**
		 * This method set client who rented car
		 * 
		 * @param clientRented
		 *            client who rented car
		 * @return new object with client who rented car
		 */
		public RentingCarEntityBuilder withClientRented(ClientEntity clientRented) {
			this.clientRented = clientRented;
			return this;
		}

		/**
		 * This method set car which was rented.
		 * 
		 * @param car
		 *            car which was rented
		 * @return new object with car witch was rented
		 */
		public RentingCarEntityBuilder withCar(CarEntity car) {
			this.car = car;
			return this;
		}

		/**
		 * This method set return date.
		 * 
		 * @param returnDate
		 *            date when car was return
		 * @return new object with return date
		 */
		public RentingCarEntityBuilder withReturnDate(LocalDate returnDate) {
			this.returnDate = returnDate;
			return this;
		}

		/**
		 * This method set return institution.
		 * 
		 * @param institutionReturn
		 *            place where car was return
		 * @return new object with return place
		 */
		public RentingCarEntityBuilder withInstitutionReturn(InstitutionEntity institutionReturn) {
			this.institutionReturn = institutionReturn;
			return this;
		}

		/**
		 * This method set rental price
		 * 
		 * @param price
		 *            rental price
		 * @return new object with rental price
		 */
		public RentingCarEntityBuilder withPrice(double price) {
			this.price = price;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object renting car
		 */
		public RentingCarEntity build() {
			checkBeforeBuild();
			return new RentingCarEntity(this);
		}

		private void checkBeforeBuild() {
			if (pickupDate == null || institutionPickup == null || clientRented == null || car == null) {
				throw new IncorrectParameterException("This rent can't be created.");
			}
		}
	}
}
