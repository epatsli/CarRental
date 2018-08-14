package com.capgemini.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCar;

	@Column(name = "type", length = 32, nullable = false)
	private String type;

	@Column(name = "brand", length = 32, nullable = false)
	private String brand;

	@Column(name = "model", length = 32, nullable = false)
	private String model;

	@Column(name = "color", length = 32, nullable = true)
	private String color;

	@Column(name = "engine_capacity", nullable = true)
	private int engine_capacity;

	@Column(name = "engine_power", nullable = true)
	private int engine_power;

	@Column(name = "mileage", nullable = true)
	private int mileage;

	@Column(name = "year", nullable = true)
	private int year;

	@OneToMany(mappedBy = "car", cascade = CascadeType.PERSIST)
	private List<RentingCarEntity> listRentingCar = new ArrayList<>();

	@ManyToMany(mappedBy = "carKeeper", cascade = CascadeType.PERSIST)
	private List<EmployeeEntity> employeeKeeper = new ArrayList<>();

	public CarEntity() {
	}

	public CarEntity(CarEntityBuilder builder) {
		this.idCar = builder.idCar;
		this.type = builder.type;
		this.brand = builder.brand;
		this.model = builder.model;
		this.color = builder.color;
		this.engine_capacity = builder.engine_capacity;
		this.engine_power = builder.engine_power;
		this.mileage = builder.mileage;
		this.year = builder.year;
		this.listRentingCar = builder.listRentingCar;
		this.employeeKeeper = builder.employeeKeeper;
	}

	public CarEntityBuilder build() {
		return new CarEntityBuilder();
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEngine_capacity() {
		return engine_capacity;
	}

	public void setEngine_capacity(int engine_capacity) {
		this.engine_capacity = engine_capacity;
	}

	public int getEngine_power() {
		return engine_power;
	}

	public void setEngine_power(int engine_power) {
		this.engine_power = engine_power;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<RentingCarEntity> getListRentingCar() {
		return listRentingCar;
	}

	public void setListRentingCar(List<RentingCarEntity> listRentingCar) {
		this.listRentingCar = listRentingCar;
	}

	public List<EmployeeEntity> getListEmployeeKeeper() {
		return employeeKeeper;
	}

	public void setListEmployeeKeeper(List<EmployeeEntity> employeeKeeper) {
		this.employeeKeeper = employeeKeeper;
	}

	public static class CarEntityBuilder {
		private int idCar;
		private String type;
		private String brand;
		private String model;
		private String color;
		private int engine_capacity;
		private int engine_power;
		private int mileage;
		private int year;
		private List<RentingCarEntity> listRentingCar;
		private List<EmployeeEntity> employeeKeeper;

		public CarEntityBuilder() {
		}

		public CarEntityBuilder(int idCar, String type, String brand, String model) {
			this.idCar = idCar;
			this.type = type;
			this.brand = brand;
			this.model = model;
		}

		public CarEntityBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarEntityBuilder withEngine_capacity(int engine_capacity) {
			this.engine_capacity = engine_capacity;
			return this;
		}

		public CarEntityBuilder withEngine_power(int engine_power) {
			this.engine_power = engine_power;
			return this;
		}

		public CarEntityBuilder withMileage(int mileage) {
			this.mileage = mileage;
			return this;
		}

		public CarEntityBuilder withYear(int year) {
			this.year = year;
			return this;
		}

		public CarEntityBuilder withListRentingCar(List<RentingCarEntity> listRentingCar) {
			this.listRentingCar = listRentingCar;
			return this;
		}

		public CarEntityBuilder withEmployeeKeeper(List<EmployeeEntity> employeeKeeper) {
			this.employeeKeeper = employeeKeeper;
			return this;
		}

		public CarEntity build() {
			return new CarEntity(this);
		}

	}

}
