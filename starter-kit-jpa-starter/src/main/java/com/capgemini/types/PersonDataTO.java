package com.capgemini.types;

import java.time.LocalDate;

public class PersonDataTO {

	private String firstName;
	private String lastName;
	private LocalDate dataOfBirth;

	/**
	 * No-argument constructor
	 */
	public PersonDataTO() {
	}

	/**
	 * Constructor with three parameters whcich create new object.
	 * 
	 * @param firstName
	 *            first name person
	 * @param lastName
	 *            surname person
	 * @param dataOfBirth
	 *            date of birth person
	 */
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
