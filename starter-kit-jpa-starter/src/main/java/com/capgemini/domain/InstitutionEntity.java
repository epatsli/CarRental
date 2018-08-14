package com.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import com.capgemini.embedded.AddressData;

@Entity
@Table(name = "INSTITUTIONS")
public class InstitutionEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idInstitution;

	@Embedded
	private AddressData address;

	@Email
	@Column(name = "email", length = 256)
	private String email;

	@Column(name = "phoneNumber", length = 16)
	private String phoneNumber;

	@Column(name = "listEmployee")
	@OneToMany(mappedBy = "institutionEmployee")
	private List<EmployeeEntity> listEmployee = new ArrayList<>();

	@Column(name = "listInstitutionPickup")
	@OneToMany(mappedBy = "institutionPickup")
	private List<InstitutionEntity> listInstitutionPickup = new ArrayList<>();

	@Column(name = "institutionReturn")
	@OneToMany(mappedBy = "institutionReturn")
	private List<InstitutionEntity> listInstitutionReturn = new ArrayList<>();

	public InstitutionEntity() {
	}

	public InstitutionEntity(InstitutionEntityBuilder build) {
		this.address = build.address;
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

	public AddressData getAddress() {
		return address;
	}

	public void setAddress(AddressData address) {
		this.address = address;
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
		private AddressData address;
		private String email;
		private String phoneNumber;
		private List<EmployeeEntity> listEmployee;
		private List<InstitutionEntity> listInstitutionPickup;
		private List<InstitutionEntity> listInstitutionReturn;

		public InstitutionEntityBuilder() {
		}

		public InstitutionEntityBuilder(AddressData address) {
			this.address = address;
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
