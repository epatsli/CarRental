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

import com.capgemini.embedded.AddressData;

@Entity
@Table(name = "INSTITUTIONS")
public class InstitutionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idInstitution;

	@Embedded
	private AddressData address;

	// @Email
	@Column(name = "email", length = 256, nullable = true)
	private String email;

	@Column(name = "phoneNumber", length = 16, nullable = true)
	private String phoneNumber;

	@Column(name = "listEmployee", nullable = true)
	@OneToMany(mappedBy = "institutionEmployee")
	private List<EmployeeEntity> listEmployee = new ArrayList<>();

	@Column(name = "listInstitutionPickup", nullable = true)
	@OneToMany(mappedBy = "institutionPickup")
	private List<InstitutionEntity> listInstitutionPickup = new ArrayList<>();

	@Column(name = "institutionReturn", nullable = true)
	@OneToMany(mappedBy = "institutionReturn")
	private List<InstitutionEntity> listInstitutionReturn = new ArrayList<>();

	public InstitutionEntity() {
	}

	public InstitutionEntity(InstitutionEntityBuilder builder) {
		this.address = builder.address;
		this.email = builder.email;
		this.phoneNumber = builder.phoneNumber;
		this.listEmployee = builder.listEmployee;
		this.listInstitutionPickup = builder.listInstitutionPickup;
		this.listInstitutionReturn = builder.listInstitutionReturn;
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

	public List<EmployeeEntity> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<EmployeeEntity> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public List<InstitutionEntity> getListInstitutionPickup() {
		return listInstitutionPickup;
	}

	public void setListInstitutionPickup(List<InstitutionEntity> listInstitutionPickup) {
		this.listInstitutionPickup = listInstitutionPickup;
	}

	public List<InstitutionEntity> getListInstitutionReturn() {
		return listInstitutionReturn;
	}

	public void setListInstitutionReturn(List<InstitutionEntity> listInstitutionReturn) {
		this.listInstitutionReturn = listInstitutionReturn;
	}

	public void setIdInstitution(int idInstitution) {
		this.idInstitution = idInstitution;
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

		public InstitutionEntityBuilder withAddress(AddressData address) {
			this.address = address;
			return this;
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
