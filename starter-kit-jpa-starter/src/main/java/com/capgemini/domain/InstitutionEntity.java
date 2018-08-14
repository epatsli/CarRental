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
	private List<InstitutionEntity> listInstitutionPickup = new ArrayList<>();

	@OneToMany(mappedBy = "institutionReturn")
	private List<InstitutionEntity> listInstitutionReturn = new ArrayList<>();

	public InstitutionEntity() {
	}

	public InstitutionEntity(InstitutionEntityBuilder build) {
		this.idInstitution = build.idInstitution;
		this.street = build.street;
		this.numberHous = build.numberHous;
		this.city = build.city;
		this.postCode = build.postCode;
		this.email = build.email;
		this.phoneNumber = build.phoneNumber;
		this.listEmployee = build.listEmployee;
		this.listInstitutionPickup = build.listInstitutionPickup;
		this.listInstitutionReturn = build.listInstitutionReturn;
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

	public static class InstitutionEntityBuilder {
		private int idInstitution;
		private String street;
		private String numberHous;
		private String city;
		private String postCode;
		private String email;
		private String phoneNumber;
		private List<EmployeeEntity> listEmployee;
		private List<InstitutionEntity> listInstitutionPickup;
		private List<InstitutionEntity> listInstitutionReturn;

		public InstitutionEntityBuilder() {
		}

		public InstitutionEntityBuilder(int idInstitution, String street, String numberHous, String city,
				String postCode) {
			this.idInstitution = idInstitution;
			this.street = street;
			this.numberHous = numberHous;
			this.city = city;
			this.postCode = postCode;
		}

		public InstitutionEntityBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public InstitutionEntityBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public InstitutionEntityBuilder withListEmployee(List<EmployeeEntity> listEmployee) {
			this.listEmployee = listEmployee;
			return this;
		}

		public InstitutionEntityBuilder withListInstitutionPickup(List<InstitutionEntity> listInstitutionPickup) {
			this.listInstitutionPickup = listInstitutionPickup;
			return this;
		}

		public InstitutionEntityBuilder withListInstitutionReturn(List<InstitutionEntity> listInstitutionReturn) {
			this.listInstitutionReturn = listInstitutionReturn;
			return this;
		}

		public InstitutionEntity build() {
			return new InstitutionEntity(this);
		}
	}
}
