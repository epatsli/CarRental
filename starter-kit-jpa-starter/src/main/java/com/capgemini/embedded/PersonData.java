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

	public PersonData(String firstName, String lastName, Date dataOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dataOfBirth = dataOfBirth;
	}

}
