package com.capgemini.types;

import com.capgemini.domain.PositionEntity;
import com.capgemini.embedded.PersonData;

public class EmployeeTO {
	private int idEmployee;
	private PersonData person;
	private PositionEntity position;

	public EmployeeTO(PersonData person, PositionEntity position) {
		this.person = person;
		this.position = position;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public PersonData getPerson() {
		return person;
	}

	public void setPerson(PersonData person) {
		this.person = person;
	}

	public PositionEntity getPosition() {
		return position;
	}

	public void setPosition(PositionEntity position) {
		this.position = position;
	}

}
