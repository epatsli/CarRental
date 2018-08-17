package com.capgemini.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.capgemini.exception.IncorrectParameterException;

@Embeddable
public class PersonData {

	@Column(name = "firstName", length = 32, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 32, nullable = false)
	private String lastName;

	@Column(name = "dateOfBirth", columnDefinition = " DATE")
	private LocalDate dataOfBirth;

	public PersonData() {
	}

	public PersonData(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		checkBeforeCreate();
	}

	public PersonData(String firstName, String lastName, LocalDate dataOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dataOfBirth = dataOfBirth;
		checkBeforeCreate();
	}

	private void checkBeforeCreate() {
		if (firstName == null || lastName == null) {
			throw new IncorrectParameterException("This person can't be created");
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

	public LocalDate getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(LocalDate dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

}
