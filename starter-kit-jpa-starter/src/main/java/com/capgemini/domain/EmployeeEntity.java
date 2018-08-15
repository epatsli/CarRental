package com.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.embedded.PersonData;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEmployee;

	@Embedded
	private PersonData person;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idPosition", nullable = false)
	private PositionEntity position;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idInstitution", nullable = true)
	private InstitutionEntity institutionEmployee;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "EMPLOYEES_CARS", joinColumns = @JoinColumn(name = "idEmployee") , inverseJoinColumns = @JoinColumn(name = "idCar") )
	private List<CarEntity> carKeeper = new ArrayList<>();

	public EmployeeEntity() {
	}

	public EmployeeEntity(PersonData person, PositionEntity position, InstitutionEntity institutionEmployee,
			List<CarEntity> carKeeper) {
		this.person = person;
		this.position = position;
		this.institutionEmployee = institutionEmployee;
		this.carKeeper = carKeeper;
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

	public InstitutionEntity getInstitutionEmployee() {
		return institutionEmployee;
	}

	public void setInstitutionEmployee(InstitutionEntity institutionEmployee) {
		this.institutionEmployee = institutionEmployee;
	}

	public List<CarEntity> getCarKeeper() {
		return carKeeper;
	}

	public void setCarKeeper(List<CarEntity> carKeeper) {
		this.carKeeper = carKeeper;
	}

}
