package com.capgemini.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POSITIONS")
public class PositionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPosition;

	@Column(name = "namePosition", length = 16, nullable = false)
	private String namePosition;

	@OneToMany(mappedBy = "position")
	private List<EmployeeEntity> listEmployee = new ArrayList<>();

	public PositionEntity() {
	}

	public PositionEntity(String namePosition) {
		this.namePosition = namePosition;
	}

	public int getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	public String getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

}
