package com.capgemini.types;

import java.util.List;

public class InstitutionTO {
	private Long idInstitution;
	private AddressDataTO address;
	private String email;
	private String phoneNumber;
	private List<EmployeeTO> listEmployee;
	private List<RentingCarTO> listInstitutionPickup;
	private List<RentingCarTO> listInstitutionReturn;

	public InstitutionTO() {
	}

	public InstitutionTO(InstitutionTOBuilder build) {
		this.idInstitution = build.idInstitution;
		this.address = build.address;
		this.email = build.email;
		this.phoneNumber = build.phoneNumber;
		this.listEmployee = build.listEmployee;
		this.listInstitutionPickup = build.listInstitutionPickup;
		this.listInstitutionReturn = build.listInstitutionReturn;
	}

	public Long getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Long idInstitution) {
		this.idInstitution = idInstitution;
	}

	public AddressDataTO getAddress() {
		return address;
	}

	public void setAddress(AddressDataTO address) {
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

	public List<EmployeeTO> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<EmployeeTO> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public List<RentingCarTO> getListInstitutionPickup() {
		return listInstitutionPickup;
	}

	public void setListInstitutionPickup(List<RentingCarTO> listInstitutionPickup) {
		this.listInstitutionPickup = listInstitutionPickup;
	}

	public List<RentingCarTO> getListInstitutionReturn() {
		return listInstitutionReturn;
	}

	public void setListInstitutionReturn(List<RentingCarTO> listInstitutionReturn) {
		this.listInstitutionReturn = listInstitutionReturn;
	}

	public static class InstitutionTOBuilder {
		private Long idInstitution;
		private AddressDataTO address;
		private String email;
		private String phoneNumber;
		private List<EmployeeTO> listEmployee;
		private List<RentingCarTO> listInstitutionPickup;
		private List<RentingCarTO> listInstitutionReturn;

		public InstitutionTOBuilder() {
		}

		public InstitutionTOBuilder withIdInstitution(Long idInstitution) {
			this.idInstitution = idInstitution;
			return this;
		}

		public InstitutionTOBuilder withAddress(AddressDataTO address) {
			this.address = address;
			return this;
		}

		public InstitutionTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public InstitutionTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public InstitutionTOBuilder withListEmployee(List<EmployeeTO> listEmployee) {
			this.listEmployee = listEmployee;
			return this;
		}

		public InstitutionTOBuilder withListInstitutionPickup(List<RentingCarTO> listInstitutionPickup) {
			this.listInstitutionPickup = listInstitutionPickup;
			return this;
		}

		public InstitutionTOBuilder withListInstitutionReturn(List<RentingCarTO> listInstitutionReturn) {
			this.listInstitutionReturn = listInstitutionReturn;
			return this;
		}

		public InstitutionTO build() {
			return new InstitutionTO(this);
		}
	}
}
