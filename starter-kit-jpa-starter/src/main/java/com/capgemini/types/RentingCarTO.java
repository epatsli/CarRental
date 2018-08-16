package com.capgemini.types;

import java.util.Date;

public class RentingCarTO {
	private Long idRenting;
	private Date pickupDate;
	private Date returnDate;
	private double price;
	private InstitutionTO institutionPickup;
	private InstitutionTO institutionReturn;
	private ClientTO clientRented;
	private CarTO car;

	public RentingCarTO() {
	}

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

	public RentingCarTOBuilder builder() {
		return new RentingCarTOBuilder();
	}

	public Long getIdRenting() {
		return idRenting;
	}

	public void setIdRenting(Long idRenting) {
		this.idRenting = idRenting;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
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

	public static class RentingCarTOBuilder {
		private Long idRenting;
		private Date pickupDate;
		private Date returnDate;
		private double price;
		private InstitutionTO institutionPickup;
		private InstitutionTO institutionReturn;
		private ClientTO clientRented;
		private CarTO car;

		public RentingCarTOBuilder() {
		}

		public RentingCarTOBuilder withIdRenting(Long idRenting) {
			this.idRenting = idRenting;
			return this;
		}

		public RentingCarTOBuilder withPickupDate(Date pickupDate) {
			this.pickupDate = pickupDate;
			return this;
		}

		public RentingCarTOBuilder withInstitutionPickup(InstitutionTO institutionPickup) {
			this.institutionPickup = institutionPickup;
			return this;
		}

		public RentingCarTOBuilder withClientRented(ClientTO clientRented) {
			this.clientRented = clientRented;
			return this;
		}

		public RentingCarTOBuilder withCar(CarTO car) {
			this.car = car;
			return this;
		}

		public RentingCarTOBuilder withReturnDate(Date returnDate) {
			this.returnDate = returnDate;
			return this;
		}

		public RentingCarTOBuilder withInstitutionReturn(InstitutionTO institutionReturn) {
			this.institutionReturn = institutionReturn;
			return this;
		}

		public RentingCarTOBuilder withPrice(double price) {
			this.price = price;
			return this;
		}

		public RentingCarTO build() {
			checkBeforeBuild();
			return new RentingCarTO(this);
		}

		private void checkBeforeBuild() {
			if (pickupDate == null || institutionPickup == null || clientRented == null || car == null) {
				throw new RuntimeException("This rent can't be created.");
			}
		}
	}

}
