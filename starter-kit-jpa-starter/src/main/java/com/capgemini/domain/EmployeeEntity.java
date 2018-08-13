package com.capgemini.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEmployee;

	@Column(name = "firstName", length = 32, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 32, nullable = false)
	private String lastName;

	@Column(name = "position", nullable = false)
	@ManyToOne(cascade = CascadeType.PERSIST)
	private PositionEntity position;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private InstitutionEntity institutionEmployee;

	@Column(name = "dateOfBirth", columnDefinition = " DATE", nullable = true)
	private Date dataOfBirth;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "EMPLOYEES_CARS", joinColumns = @JoinColumn(name = "idEmployee") , inverseJoinColumns = @JoinColumn(name = "idCar") )
	private List<CarEntity> carKeeper = new ArrayList<>();

	public EmployeeEntity() {
	}

	public EmployeeEntity(String firstName, String lastName, PositionEntity position,
			InstitutionEntity institutionEmployee, Date dataOfBirth, List<CarEntity> carKeeper) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.institutionEmployee = institutionEmployee;
		this.dataOfBirth = dataOfBirth;
		this.carKeeper = carKeeper;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
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

	public Date getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public List<CarEntity> getCarKeeper() {
		return carKeeper;
	}

	public void setCarKeeper(List<CarEntity> carKeeper) {
		this.carKeeper = carKeeper;
	}

	public static class EmployeeEntityBuilder {

		private int idEmployee;
		private String firstName;
		private String lastName;
		private PositionEntity position;
		private InstitutionEntity institutionEmployee;
		private Date dataOfBirth;

		public EmployeeEntityBuilder(int idEmployee, String firstName, String lastName, int position) {
			this.idEmployee = idEmployee;
			this.firstName = firstName;
			this.lastName = lastName;
			this.position = position;
		}

	}

}
