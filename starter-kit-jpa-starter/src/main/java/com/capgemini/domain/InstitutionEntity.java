package com.capgemini.domain;

import java.util.ArrayList;
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
@Table(name = "INSTITUTIONS")
public class InstitutionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idInstitution;

	@Column(name = "street", length = 32)
	private String street;

	@Column(name = "numberHous", length = 16)
	private String numberHous;

	@Column(name = "city", length = 32)
	private String city;

	@Column(name = "postCode", length = 8)
	private String postCode;

	@Email
	@Column(name = "email", length = 256)
	private String email;

	@Column(name = "phoneNumber", length = 16)
	private String phoneNumber;

	@OneToMany(mappedBy = "institutionEmployee")
	private List<EmployeeEntity> listEmployee = new ArrayList<>();

	@OneToMany(mappedBy = "institutionPickup")
	private List<EmployeeEntity> listInstitutionPickup = new ArrayList<>();

	@OneToMany(mappedBy = "institutionReturn")
	private List<EmployeeEntity> listInstitutionReturn = new ArrayList<>();

	public InstitutionEntity() {
	}

	public InstitutionEntity(String street, String numberHous, String city, String postCode, String email,
			String phoneNumber) {
		this.street = street;
		this.numberHous = numberHous;
		this.city = city;
		this.postCode = postCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getIdInstitution() {
		return idInstitution;
	}

	public void setId(int idInstitution) {
		this.idInstitution = idInstitution;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
