package com.capgemini.types;

import java.util.List;

import com.capgemini.exception.IncorrectParameterException;

public class ClientTO {

	private Long idClient;
	private String phoneNumber;
	private String creditCardNumber;
	private String email;
	private PersonDataTO person;
	private AddressDataTO address;
	private List<RentingCarTO> listRentingCars;

	/**
	 * No-argument constructor
	 */
	public ClientTO() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public ClientTO(ClientTOBuilder builder) {
		this.idClient = builder.idClient;
		this.person = builder.person;
		this.phoneNumber = builder.phoneNumber;
		this.creditCardNumber = builder.creditCardNumber;
		this.email = builder.email;
		this.address = builder.address;
		this.listRentingCars = builder.listRentingCars;
	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public ClientTOBuilder builder() {
		return new ClientTOBuilder();
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	public PersonDataTO getPerson() {
		return person;
	}

	public void setPerson(PersonDataTO person) {
		this.person = person;
	}

	public AddressDataTO getAddress() {
		return address;
	}

	public void setAddress(AddressDataTO address) {
		this.address = address;
	}

	public List<RentingCarTO> getListRentingCars() {
		return listRentingCars;
	}

	public void setListRentingCars(List<RentingCarTO> listRentingCars) {
		this.listRentingCars = listRentingCars;
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class ClientTOBuilder {
		private Long idClient;
		private PersonDataTO person;
		private String phoneNumber;
		private String creditCardNumber;
		private String email;
		private AddressDataTO address;
		private List<RentingCarTO> listRentingCars;

		/**
		 * No-argument constructor
		 */
		public ClientTOBuilder() {
		}

		/**
		 * This method set personal data client.
		 * 
		 * @param person
		 *            personal data client
		 * @return new object with personal data client
		 */
		public ClientTOBuilder withPersonDataTO(PersonDataTO person) {
			this.person = person;
			return this;
		}

		/**
		 * This method set client
		 * 
		 * @param idClient
		 *            client index
		 * @return new object with client index
		 */
		public ClientTOBuilder withIdClient(Long idClient) {
			this.idClient = idClient;
			return this;
		}

		/**
		 * This method set phone number client.
		 * 
		 * @param phoneNumber
		 *            phone number client
		 * @return new object with phone number client
		 */
		public ClientTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		/**
		 * This method set credit card numbers
		 * 
		 * @param creditCardNumber
		 * @return new object with credit card numbers
		 */
		public ClientTOBuilder withCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		/**
		 * This method set email.
		 * 
		 * @param email
		 * @return new object with address email
		 */
		public ClientTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * This method set client address.
		 * 
		 * @param address
		 *            client address
		 * @return new object with address
		 */
		public ClientTOBuilder withAddress(AddressDataTO address) {
			this.address = address;
			return this;
		}

		/**
		 * This method set list of renting car one clients.
		 * 
		 * @param listRentingCars
		 *            list of renting car by one client
		 * @return new object with list of renting cars
		 */
		public ClientTOBuilder withListRentingCars(List<RentingCarTO> listRentingCars) {
			this.listRentingCars = listRentingCars;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object client
		 */
		public ClientTO build() {
			checkBeforeBuild();
			return new ClientTO(this);
		}

		private void checkBeforeBuild() {

			if (phoneNumber == null || creditCardNumber == null) {
				throw new IncorrectParameterException("Thic client can't be created.");
			}

		}
	}
}
