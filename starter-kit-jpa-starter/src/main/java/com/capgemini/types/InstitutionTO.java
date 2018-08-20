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

	/**
	 * No-argument constructor
	 */
	public InstitutionTO() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public InstitutionTO(InstitutionTOBuilder builder) {
		this.idInstitution = builder.idInstitution;
		this.address = builder.address;
		this.email = builder.email;
		this.phoneNumber = builder.phoneNumber;
		this.listEmployee = builder.listEmployee;
		this.listInstitutionPickup = builder.listInstitutionPickup;
		this.listInstitutionReturn = builder.listInstitutionReturn;
	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public InstitutionTOBuilder builder() {
		return new InstitutionTOBuilder();
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

	/**
	 * This is builder class.
	 *
	 */
	public static class InstitutionTOBuilder {
		private Long idInstitution;
		private AddressDataTO address;
		private String email;
		private String phoneNumber;
		private List<EmployeeTO> listEmployee;
		private List<RentingCarTO> listInstitutionPickup;
		private List<RentingCarTO> listInstitutionReturn;

		/**
		 * No-argument constructor
		 */
		public InstitutionTOBuilder() {
		}

		/**
		 * This method set index institution.
		 * 
		 * @param idInstitution
		 *            index institution
		 * @return new object with index
		 */
		public InstitutionTOBuilder withIdInstitution(Long idInstitution) {
			this.idInstitution = idInstitution;
			return this;
		}

		/**
		 * This method set address institution.
		 * 
		 * @param address
		 *            address institution
		 * @return new object with address institution
		 */
		public InstitutionTOBuilder withAddress(AddressDataTO address) {
			this.address = address;
			return this;
		}

		/**
		 * This method set email institution.
		 * 
		 * @param email
		 *            email institution
		 * @return new object with email
		 */
		public InstitutionTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * This method set phone number institution
		 * 
		 * @param phoneNumber
		 *            phone number institution
		 * @return new object with phone number
		 */
		public InstitutionTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		/**
		 * This method set list employee for institution.
		 * 
		 * @param listEmployee
		 *            list of employee which work in institution
		 * @return new object with list employee
		 */
		public InstitutionTOBuilder withListEmployee(List<EmployeeTO> listEmployee) {
			this.listEmployee = listEmployee;
			return this;
		}

		/**
		 * This method set list renting which was take from this institution.
		 * 
		 * @param listInstitutionPickup
		 *            list renting from this institution
		 * @return new object with list renting
		 */
		public InstitutionTOBuilder withListInstitutionPickup(List<RentingCarTO> listInstitutionPickup) {
			this.listInstitutionPickup = listInstitutionPickup;
			return this;
		}

		/**
		 * This method set list renting which was return in this institution.
		 * 
		 * @param listInstitutionReturn
		 *            list renting return in this institution
		 * @return new object with list renting
		 */
		public InstitutionTOBuilder withListInstitutionReturn(List<RentingCarTO> listInstitutionReturn) {
			this.listInstitutionReturn = listInstitutionReturn;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object institution
		 */
		public InstitutionTO build() {
			return new InstitutionTO(this);
		}
	}
}
