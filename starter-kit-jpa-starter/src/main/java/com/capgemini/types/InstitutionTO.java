package com.capgemini.types;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.InstitutionEntity;
import com.capgemini.embedded.AddressData;

public class InstitutionTO {
	private int idInstitution;
	private AddressData address;
	private String email;
	private String phoneNumber;
	private List<EmployeeEntity> listEmployee;
	private List<InstitutionEntity> listInstitutionPickup;
	private List<InstitutionEntity> listInstitutionReturn;

	public InstitutionTO() {
	}

	public InstitutionTO(InstitutionTOBuilder build) {
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

	public void setIdInstitution(int idInstitution) {
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

	public static class InstitutionTOBuilder {
		private AddressData address;
		private String email;
		private String phoneNumber;
		private List<EmployeeEntity> listEmployee;
		private List<InstitutionEntity> listInstitutionPickup;
		private List<InstitutionEntity> listInstitutionReturn;

		public InstitutionTOBuilder(AddressData address) {
			this.address = address;
		}

		public InstitutionTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public InstitutionTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public InstitutionTOBuilder withListEmployee(List<EmployeeEntity> listEmployee) {
			this.listEmployee = listEmployee;
			return this;
		}

		public InstitutionTOBuilder withListInstitutionPickup(List<InstitutionEntity> listInstitutionPickup) {
			this.listInstitutionPickup = listInstitutionPickup;
			return this;
		}

		public InstitutionTOBuilder withListInstitutionReturn(List<InstitutionEntity> listInstitutionReturn) {
			this.listInstitutionReturn = listInstitutionReturn;
			return this;
		}

		public InstitutionTO build() {
			return new InstitutionTO(this);
		}
	}
}
