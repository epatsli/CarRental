package com.capgemini.domain;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name = "RENTINGCARS")
public class RentingCarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRenting;

	@Column(name = "pickupDate", nullable = false)
	private Date pickupDate;

	@Column(name = "returnDate", nullable = true)
	private Date returnDate;

	@Column(name = "price", nullable = true)
	private double price;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idInstitution", nullable = false)
	private InstitutionEntity institutionPickup;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idInstitution", nullable = true)
	private InstitutionEntity institutionReturn;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idClient", nullable = false)
	private ClientEntity clientRented;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCar", nullable = false)
	private CarEntity car;

	public RentingCarEntity() {
	}

	public RentingCarEntity(Date pickupDate, Date returnDate, double price) {
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.price = price;
	}

	public int getIdRenting() {
		return idRenting;
	}

	public void setIdRenting(int idRenting) {
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

}
