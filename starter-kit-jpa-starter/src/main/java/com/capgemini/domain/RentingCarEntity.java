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

	public RentingCarEntity(Date pickupDate, Date returnDate, InstitutionEntity institutionPickup,
			InstitutionEntity institutionReturn, ClientEntity clientRented, CarEntity car) {
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.institutionPickup = institutionPickup;
		this.institutionReturn = institutionReturn;
		this.clientRented = clientRented;
		this.car = car;
	}

}
