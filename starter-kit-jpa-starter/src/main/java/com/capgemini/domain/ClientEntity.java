package com.capgemini.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "CLIENTS")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;

	@Column(name = "firstName", length = 32, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 32, nullable = false)
	private String lastName;

	@Column(name = "dateOfBirth", columnDefinition = " DATE", nullable = false)
	private Date dataOfBirth;

	@Column(name = "phoneNumber", length = 16, nullable = false)
	private String phoneNumber;

	@Column(name = "creditCardNumber", length = 16, nullable = false)
	private String creditCardNumber;

	@Email
	@Column(name = "email", length = 32, nullable = true)
	private String email;

	@Column(name = "street", length = 32, nullable = true)
	private String street;

	@Column(name = "numberHous", length = 16, nullable = true)
	private String numberHous;

	@Column(name = "city", length = 32, nullable = true)
	private String city;

	@Column(name = "postCode", length = 8, nullable = true)
	private String postCode;

	@OneToMany(mappedBy = "clientRented")
	private List<RentingCarEntity> listRentingCars = new ArrayList<>();

	public ClientEntity() {
	}

	public ClientEntity(String firstName, String lastName, Date dataOfBirth, String phoneNumber,
			String creditCardNumber, String email, String street, String numberHous, String city, String postCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dataOfBirth = dataOfBirth;
		this.phoneNumber = phoneNumber;
		this.creditCardNumber = creditCardNumber;
		this.email = email;
		this.street = street;
		this.numberHous = numberHous;
		this.city = city;
		this.postCode = postCode;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberHous() {
		return numberHous;
	}

	public void setNumberHous(String numberHous) {
		this.numberHous = numberHous;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
