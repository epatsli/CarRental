package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.capgemini.exception.IncorrectParameterException;

/**
 * This class contain personal date.
 *
 */
@Embeddable
public class PersonData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "firstName", length = 32, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 32, nullable = false)
	private String lastName;

	@Column(name = "dateOfBirth", columnDefinition = " DATE")
	private LocalDate dataOfBirth;

	/**
	 * No-argument constructor
	 */
	public PersonData() {
	}

	/**
	 * Constructor with two parameters create new object.
	 * 
	 * @param firstName
	 *            first name person
	 * @param lastName
	 *            surname person
	 */
	public PersonData(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		checkBeforeCreate();
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
