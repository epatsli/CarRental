package com.capgemini.types;

import com.capgemini.embedded.PersonDataTO;

public class EmployeeTO {
	private int idEmployee;
	private PersonDataTO person;
	private PositionTO position;

	public EmployeeTO(PersonDataTO person, PositionTO position) {
		this.person = person;
		this.position = position;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public PersonDataTO getPerson() {
		return person;
	}

	public void setPerson(PersonDataTO person) {
		this.person = person;
	}

	public PositionTO getPosition() {
		return position;
	}

	public void setPosition(PositionTO position) {
		this.position = position;
	}

}
