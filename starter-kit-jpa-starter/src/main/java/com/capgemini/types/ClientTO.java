package com.capgemini.types;

import java.util.List;

public class ClientTO {

	private Long idClient;
	private String phoneNumber;
	private String creditCardNumber;
	private String email;
	private PersonDataTO person;
	private AddressDataTO address;
	private List<RentingCarTO> listRentingCars;

	public ClientTO() {
	}

	public ClientTO(ClientTOBuilder builder) {
		this.idClient = builder.idClient;
		this.person = builder.person;
		this.phoneNumber = builder.phoneNumber;
		this.creditCardNumber = builder.creditCardNumber;
		this.email = builder.email;
		this.address = builder.address;
		this.listRentingCars = builder.listRentingCars;
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

	public static class ClientTOBuilder {
		private Long idClient;
		private PersonDataTO person;
		private String phoneNumber;
		private String creditCardNumber;
		private String email;
		private AddressDataTO address;
		private List<RentingCarTO> listRentingCars;

		public ClientTOBuilder() {
		}

		public ClientTOBuilder withPersonDataTO(PersonDataTO person) {
			this.person = person;
			return this;
		}

		public ClientTOBuilder withIdClient(Long idClient) {
			this.idClient = idClient;
			return this;
		}

		public ClientTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public ClientTOBuilder withCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		public ClientTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public ClientTOBuilder withAddress(AddressDataTO address) {
			this.address = address;
			return this;
		}

		public ClientTOBuilder withListRentingCars(List<RentingCarTO> listRentingCars) {
			this.listRentingCars = listRentingCars;
			return this;
		}

		public ClientTO builder() {
			checkBeforeBuild();
			return new ClientTO(this);
		}

		private void checkBeforeBuild() {

			if (phoneNumber == null || creditCardNumber == null) {
				throw new RuntimeException("Thic client can't be created.");
			}

		}
	}
}
