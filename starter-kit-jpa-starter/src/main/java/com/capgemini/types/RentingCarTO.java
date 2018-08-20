package com.capgemini.types;

import java.time.LocalDate;

import com.capgemini.exception.IncorrectParameterException;

public class RentingCarTO {
	private Long idRenting;
	private LocalDate pickupDate;
	private LocalDate returnDate;
	private double price;
	private InstitutionTO institutionPickup;
	private InstitutionTO institutionReturn;
	private ClientTO clientRented;
	private CarTO car;

	/**
	 * No-argument constructor
	 */
	public RentingCarTO() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public RentingCarTO(RentingCarTOBuilder builder) {
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
	public RentingCarTOBuilder builder() {
		return new RentingCarTOBuilder();
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

	public InstitutionTO getInstitutionPickup() {
		return institutionPickup;
	}

	public void setInstitutionPickup(InstitutionTO institutionPickup) {
		this.institutionPickup = institutionPickup;
	}

	public InstitutionTO getInstitutionReturn() {
		return institutionReturn;
	}

	public void setInstitutionReturn(InstitutionTO institutionReturn) {
		this.institutionReturn = institutionReturn;
	}

	public ClientTO getClientRented() {
		return clientRented;
	}

	public void setClientRented(ClientTO clientRented) {
		this.clientRented = clientRented;
	}

	public CarTO getCar() {
		return car;
	}

	public void setCar(CarTO car) {
		this.car = car;
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class RentingCarTOBuilder {
		private Long idRenting;
		private LocalDate pickupDate;
		private LocalDate returnDate;
		private double price;
		private InstitutionTO institutionPickup;
		private InstitutionTO institutionReturn;
		private ClientTO clientRented;
		private CarTO car;

		/**
		 * No-argument constructor
		 */
		public RentingCarTOBuilder() {
		}

		/**
		 * 
		 * This method set index renting.
		 * 
		 * @param idRenting
		 *            index renting
		 * @return new object with index
		 */
		public RentingCarTOBuilder withIdRenting(Long idRenting) {
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
		public RentingCarTOBuilder withPickupDate(LocalDate pickupDate) {
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
		public RentingCarTOBuilder withInstitutionPickup(InstitutionTO institutionPickup) {
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
		public RentingCarTOBuilder withClientRented(ClientTO clientRented) {
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
		public RentingCarTOBuilder withCar(CarTO car) {
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
		public RentingCarTOBuilder withReturnDate(LocalDate returnDate) {
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
		public RentingCarTOBuilder withInstitutionReturn(InstitutionTO institutionReturn) {
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
		public RentingCarTOBuilder withPrice(double price) {
			this.price = price;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object renting car
		 */
		public RentingCarTO build() {
			checkBeforeBuild();
			return new RentingCarTO(this);
		}

		private void checkBeforeBuild() {
			if (pickupDate == null || institutionPickup == null || clientRented == null || car == null) {
				throw new IncorrectParameterException("This rent can't be created.");
			}
		}
	}

}
