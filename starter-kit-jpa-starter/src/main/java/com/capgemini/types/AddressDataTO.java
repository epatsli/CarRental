package com.capgemini.types;

import com.capgemini.exception.IncorrectParameterException;

public class AddressDataTO {
	private String street;
	private String houseNumber;
	private String city;
	private String postCode;

	public AddressDataTO() {
	}

	public AddressDataTO(AddressDataTOBuilder build) {
		this.street = build.street;
		this.houseNumber = build.houseNumber;
		this.city = build.city;
		this.postCode = build.postCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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

	public static class AddressDataTOBuilder {
		private String street;
		private String houseNumber;
		private String city;
		private String postCode;

		public AddressDataTOBuilder() {
		}

		public AddressDataTOBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressDataTOBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public AddressDataTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public AddressDataTOBuilder withPostCode(String postCode) {
			this.postCode = postCode;
			return this;
		}

		private void checkBeforeBuild() {
			if (street == null || houseNumber == null || city == null || postCode == null) {
				throw new IncorrectParameterException("This address can't be created.");
			}
		}

		public AddressDataTO build() {
			checkBeforeBuild();
			return new AddressDataTO(this);
		}

	}

}
