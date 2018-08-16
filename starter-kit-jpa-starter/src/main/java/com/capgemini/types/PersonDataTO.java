package com.capgemini.types;

import java.util.Date;

public class PersonDataTO {

	private String firstName;
	private String lastName;
	private Date dataOfBirth;

	public PersonDataTO() {
	}

	public PersonDataTO(String firstName, String lastName, Date dataOfBirth) {
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
