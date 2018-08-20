package com.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class maps position tables.
 *
 */
@Entity
@Table(name = "POSITIONS")
public class PositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPosition;

	@Column(name = "namePosition", length = 16, nullable = false)
	private String namePosition;

	@OneToMany(mappedBy = "position")
	private List<EmployeeEntity> listEmployee = new ArrayList<>();

	/**
	 * No-argument constructor
	 */
	public PositionEntity() {
	}

	/**
	 * Constructor with one parameter.
	 * 
	 * @param namePosition
	 *            name of position
	 */
	public PositionEntity(String namePosition) {
		this.namePosition = namePosition;
	}

	/**
	 * Constructor with two parameters.
	 * 
	 * @param namePosition
	 *            name of position
	 * @param listEmployee
	 *            list of employee which have specific position
	 */
	public PositionEntity(String namePosition, List<EmployeeEntity> listEmployee) {
		this.namePosition = namePosition;
		this.listEmployee = listEmployee;
	}

	public Long getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(Long idPosition) {
		this.idPosition = idPosition;
	}

	public String getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

	public List<EmployeeEntity> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<EmployeeEntity> listEmployee) {
		this.listEmployee = listEmployee;
	}

}
