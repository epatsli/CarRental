package com.capgemini.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressData {

	@Column(name = "street", length = 32, nullable = true)
	private String street;

	@Column(name = "houseNumber", length = 16, nullable = true)
	private String houseNumber;

	@Column(name = "city", length = 32, nullable = true)
	private String city;

	@Column(name = "postCode", length = 8, nullable = true)
	private String postCode;

	public AddressData() {
	}

	public AddressData(AddressDataBuilder build) {
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

	public String getNumberHous() {
		return houseNumber;
	}

	public void setNumberHous(String houseNumber) {
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

	public static class AddressDataBuilder {
		private String street;
		private String houseNumber;
		private String city;
		private String postCode;

		public AddressDataBuilder(String street, String houseNumber, String city, String postCode) {
			this.street = street;
			this.houseNumber = houseNumber;
			this.city = city;
			this.postCode = postCode;
		}

		private void checkBeforeBuild(String street, String houseNumber, String city, String postCode) {
			if (street == null || houseNumber == null || city == null || postCode == null) {
				throw new RuntimeException("Incorrect address");
			}
		}

		public AddressData build() {
			checkBeforeBuild(street, houseNumber, city, postCode);
			return new AddressData(this);
		}

	}

}
