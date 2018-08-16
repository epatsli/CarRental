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

	public ClientEntity() {
	}

	public ClientEntity(ClientEntityBuilder builder) {
		this.idClient = builder.idClient;
		this.person = builder.person;
		this.phoneNumber = builder.phoneNumber;
		this.creditCardNumber = builder.creditCardNumber;
		this.email = builder.email;
		this.address = builder.address;
		this.listRentingCars = builder.listRentingCars;
	}

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

	public static class ClientEntityBuilder {
		private Long idClient;
		private PersonData person;
		private String phoneNumber;
		private String creditCardNumber;
		private String email;
		private AddressData address;
		private List<RentingCarEntity> listRentingCars;

		public ClientEntityBuilder() {
		}

		public ClientEntityBuilder withPersonData(Long idClient) {
			this.idClient = idClient;
			return this;
		}

		public ClientEntityBuilder withPersonData(PersonData person) {
			this.person = person;
			return this;
		}

		public ClientEntityBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public ClientEntityBuilder withCredicalNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		public ClientEntityBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public ClientEntityBuilder withAddress(AddressData address) {
			this.address = address;
			return this;
		}

		public ClientEntityBuilder withListRentingCars(List<RentingCarEntity> listRentingCars) {
			this.listRentingCars = listRentingCars;
			return this;
		}

		public ClientEntity build() {
			checkBeforeBuild();
			return new ClientEntity(this);
		}

		private void checkBeforeBuild() {

			if (phoneNumber == null || creditCardNumber == null) {
				throw new RuntimeException("Thic client can't be created.");
			}

		}

	}
}
