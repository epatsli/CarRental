package com.capgemini.types;

import com.capgemini.exception.IncorrectParameterException;

/**
 * This class save address.
 * 
 */
public class AddressDataTO {
	private String street;
	private String houseNumber;
	private String city;
	private String postCode;

	/**
	 * No-argument constructor
	 */
	public AddressDataTO() {
	}

	/**
	 * Constructor creating an address with the help of a builder.
	 * 
	 * @param build
	 *            object AddressDataBuilder
	 * 
	 */
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

	/**
	 * This is auxiliary class to build new object.
	 *
	 */
	public static class AddressDataTOBuilder {
		private String street;
		private String houseNumber;
		private String city;
		private String postCode;

		/**
		 * No-argument constructor
		 */
		public AddressDataTOBuilder() {
		}

		/**
		 * Method which create object with street name.
		 * 
		 * @param street
		 *            new street name
		 * @return new object
		 */
		public AddressDataTOBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		/**
		 * Method which create object with house number.
		 * 
		 * @param houseNumber
		 * @return new object
		 */
		public AddressDataTOBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		/**
		 * Method which create object with city name.
		 * 
		 * @param city
		 * @return new object
		 */
		public AddressDataTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		/**
		 * Method which create object with post code.
		 * 
		 * @param postCode
		 * @return new object
		 */
		public AddressDataTOBuilder withPostCode(String postCode) {
			this.postCode = postCode;
			return this;
		}

		private void checkBeforeBuild() {
			if (street == null || houseNumber == null || city == null || postCode == null) {
				throw new IncorrectParameterException("This address can't be created.");
			}
		}

		/**
		 * This method creates a new object if we provide all the required
		 * parameters.
		 * 
		 * @return new object
		 */
		public AddressDataTO build() {
			checkBeforeBuild();
			return new AddressDataTO(this);
		}

	}

}
