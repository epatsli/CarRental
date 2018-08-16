package com.capgemini.embedded;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonData {

	@Column(name = "firstName", length = 32, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 32, nullable = false)
	private String lastName;

	@Column(name = "dateOfBirth", columnDefinition = " DATE", nullable = true)
	private Date dataOfBirth;

	public PersonData() {
	}

	public PersonData(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		checkBeforeCreate();
	}

	public PersonData(String firstName, String lastName, Date dataOfBirth) {
		checkBeforeCreate();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dataOfBirth = dataOfBirth;
	}

	private void checkBeforeCreate() {
		if (firstName == null || lastName == null) {
			throw new RuntimeException("This person can't be created");
		}

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

}
