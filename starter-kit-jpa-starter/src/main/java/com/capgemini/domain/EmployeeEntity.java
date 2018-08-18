package com.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEmployee;

	@Embedded
	private PersonData person;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idPosition")
	private PositionEntity position;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idInstitution")
	private InstitutionEntity institutionEmployee;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "EMPLOYEES_CARS", joinColumns = @JoinColumn(name = "idEmployee") , inverseJoinColumns = @JoinColumn(name = "idCar") )
	private List<CarEntity> carKeeper = new ArrayList<>();

	public EmployeeEntity() {
	}

	public EmployeeEntity(EmployeeEntityBuilder builder) {
		this.idEmployee = builder.idEmployee;
		this.person = builder.person;
		this.position = builder.position;
		this.institutionEmployee = builder.institutionEmployee;
		this.carKeeper = builder.carKeeper;
	}

	public EmployeeEntityBuilder builder() {
		return new EmployeeEntityBuilder();
	}

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
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

	public static class EmployeeEntityBuilder {
		private Long idEmployee;
		private PersonData person;
		private PositionEntity position;
		private InstitutionEntity institutionEmployee;
		private List<CarEntity> carKeeper;

		public EmployeeEntityBuilder() {
		}

		public EmployeeEntityBuilder withIdEmployee(Long idEmployee) {
			this.idEmployee = idEmployee;
			return this;
		}

		public EmployeeEntityBuilder withPerson(PersonData person) {
			this.person = person;
			return this;
		}

		public EmployeeEntityBuilder withPosition(PositionEntity position) {
			this.position = position;
			return this;
		}

		public EmployeeEntityBuilder withInstitutionEmployee(InstitutionEntity institutionEmployee) {
			this.institutionEmployee = institutionEmployee;
			return this;
		}

		public EmployeeEntityBuilder withCarKeeper(List<CarEntity> carKeeper) {
			this.carKeeper = carKeeper;
			return this;
		}

		public EmployeeEntity build() {
			return new EmployeeEntity(this);
		}

	}

}
