package com.capgemini.types;

import java.time.LocalDate;

public class PersonDataTO {

	private String firstName;
	private String lastName;
	private LocalDate dataOfBirth;

	public PersonDataTO() {
	}

	public PersonDataTO(String firstName, String lastName, LocalDate dataOfBirth) {
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

	public LocalDate getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(LocalDate dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

}
