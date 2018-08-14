package com.capgemini.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RENTINGCARS")
public class RentingCarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRenting;

	@Column(name = "pickupDate", nullable = true)
	private Date pickupDate;

	@Column(name = "returnDate", nullable = true)
	private Date returnDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private InstitutionEntity institutionPickup;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private InstitutionEntity institutionReturn;

	@ManyToOne
	private ClientEntity clientRented;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private CarEntity car;

	public RentingCarEntity() {
	}

	public RentingCarEntity(RentingCarEntityBuilder build) {
		this.pickupDate = build.pickupDate;
		this.returnDate = build.returnDate;
		this.institutionPickup = build.institutionPickup;
		this.institutionReturn = build.institutionReturn;
		this.clientRented = build.clientRented;
		this.car = build.car;
	}

	public static class RentingCarEntityBuilder {
		private Date pickupDate;
		private Date returnDate;
		private InstitutionEntity institutionPickup;
		private InstitutionEntity institutionReturn;
		private ClientEntity clientRented;
		private CarEntity car;

		public RentingCarEntityBuilder() {
		}

		public RentingCarEntityBuilder(Date pickupDate, InstitutionEntity institutionPickup, CarEntity car,
				ClientEntity clientRented) {
			this.clientRented = clientRented;
			this.pickupDate = pickupDate;
			this.institutionPickup = institutionPickup;
			this.car = car;
		}

		public RentingCarEntityBuilder withReturnCar(Date returnDate, InstitutionEntity institutionReturn) {
			this.returnDate = returnDate;
			this.institutionReturn = institutionReturn;
			return this;
		}

		public RentingCarEntity build() {
			return new RentingCarEntity(this);
		}

	}

}
