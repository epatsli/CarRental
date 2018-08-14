package com.capgemini.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import com.capgemini.embedded.AddressData;

@Entity
@Table(name = "CLIENTS")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;

	@Column(name = "firstName", length = 32, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 32, nullable = false)
	private String lastName;

	@Column(name = "dateOfBirth", columnDefinition = " DATE", nullable = false)
	private Date dataOfBirth;

	@Column(name = "phoneNumber", length = 16, nullable = false)
	private String phoneNumber;

	@Column(name = "creditCardNumber", length = 16, nullable = false)
	private String creditCardNumber;

	@Email
	@Column(name = "email", length = 32, nullable = true)
	private String email;

	@Embedded
	private AddressData address;

	@OneToMany(mappedBy = "clientRented")
	private List<RentingCarEntity> listRentingCars = new ArrayList<>();

	public ClientEntity() {
	}

	public ClientEntity(ClientEntityBuilder build) {
		this.firstName = build.firstName;
		this.lastName = build.lastName;
		this.dataOfBirth = build.dataOfBirth;
		this.phoneNumber = build.phoneNumber;
		this.creditCardNumber = build.creditCardNumber;
		this.email = build.email;
		this.address = build.address;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
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

		private String firstName;
		private String lastName;
		private Date dataOfBirth;
		private String phoneNumber;
		private String creditCardNumber;
		private String email;
		private AddressData address;

		public ClientEntityBuilder() {
		}

		public ClientEntityBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public ClientEntityBuilder withDataOfBirth(Date dataOfBirth) {
			this.dataOfBirth = dataOfBirth;
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

		public ClientEntity build() {
			return new ClientEntity(this);
		}

	}
}
