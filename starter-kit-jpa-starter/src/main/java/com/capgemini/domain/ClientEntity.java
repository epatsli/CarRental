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

import com.capgemini.exception.IncorrectParameterException;

/**
 * This class maps client tables.
 *
 */
@Entity
@Table(name = "CLIENTS")
public class ClientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idClient;

	@Column(name = "phoneNumber", length = 16, nullable = false)
	private String phoneNumber;

	@Column(name = "creditCardNumber", length = 16, nullable = false)
	private String creditCardNumber;

	@Column(name = "email", length = 32)
	private String email;

	@Embedded
	private PersonData person;

	@Embedded
	private AddressData address;

	@OneToMany(mappedBy = "clientRented")
	private List<RentingCarEntity> listRentingCars = new ArrayList<>();

	/**
	 * No-argument constructor
	 */
	public ClientEntity() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public ClientEntity(ClientEntityBuilder builder) {
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
	public ClientEntityBuilder builder() {
		return new ClientEntityBuilder();
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public PersonData getPerson() {
		return person;
	}

	public void setPerson(PersonData person) {
		this.person = person;
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

	public AddressData getAddress() {
		return address;
	}

	public void setAddress(AddressData address) {
		this.address = address;
	}

	public List<RentingCarEntity> getListRentingCars() {
		return listRentingCars;
	}

	public void setListRentingCars(List<RentingCarEntity> listRentingCars) {
		this.listRentingCars = listRentingCars;
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class ClientEntityBuilder {
		private Long idClient;
		private PersonData person;
		private String phoneNumber;
		private String creditCardNumber;
		private String email;
		private AddressData address;
		private List<RentingCarEntity> listRentingCars;

		/**
		 * No-argument constructor
		 */
		public ClientEntityBuilder() {
		}

		/**
		 * This method set client
		 * 
		 * @param idClient
		 *            client index
		 * @return new object with client index
		 */
		public ClientEntityBuilder withPersonData(Long idClient) {
			this.idClient = idClient;
			return this;
		}

		/**
		 * This method set personal data client.
		 * 
		 * @param person
		 *            personal data client
		 * @return new object with personal data client
		 */
		public ClientEntityBuilder withPersonData(PersonData person) {
			this.person = person;
			return this;
		}

		/**
		 * This method set phone number client.
		 * 
		 * @param phoneNumber
		 *            phone number client
		 * @return new object with phone number client
		 */
		public ClientEntityBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		/**
		 * This method set credit card numbers
		 * 
		 * @param creditCardNumber
		 * @return new object with credit card numbers
		 */
		public ClientEntityBuilder withCredicalNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		/**
		 * This method set email.
		 * 
		 * @param email
		 * @return new object with address email
		 */
		public ClientEntityBuilder withEmail(String email) {
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
		public ClientEntityBuilder withAddress(AddressData address) {
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
		public ClientEntityBuilder withListRentingCars(List<RentingCarEntity> listRentingCars) {
			this.listRentingCars = listRentingCars;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object client
		 */
		public ClientEntity build() {
			checkBeforeBuild();
			return new ClientEntity(this);
		}

		private void checkBeforeBuild() {

			if (phoneNumber == null || creditCardNumber == null) {
				throw new IncorrectParameterException("Thic client can't be created.");
			}

		}

	}
}
