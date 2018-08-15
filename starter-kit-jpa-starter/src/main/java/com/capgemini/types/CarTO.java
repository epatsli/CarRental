package com.capgemini.types;

import java.util.List;

public class CarTO {

	private int idCar;
	private String type;
	private String brand;
	private String model;
	private String color;
	private int engineCapacity;
	private int enginePower;
	private int mileage;
	private int year;
	private List<EmployeeTO> employeeKeeper;

	public CarTO() {
	}

	public CarTO(CarTOBuilder builder) {
		this.idCar = builder.idCar;
		this.type = builder.type;
		this.brand = builder.brand;
		this.model = builder.model;
		this.color = builder.color;
		this.engineCapacity = builder.engineCapacity;
		this.enginePower = builder.enginePower;
		this.mileage = builder.mileage;
		this.year = builder.year;

	}

	public static CarTOBuilder builder() {
		return new CarTOBuilder();
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
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEngine_power(int enginePower) {
		this.enginePower = enginePower;
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

	public List<EmployeeTO> getEmployeeKeeper() {
		return employeeKeeper;
	}

	public void setEmployeeKeeper(List<EmployeeTO> employeeKeeper) {
		this.employeeKeeper = employeeKeeper;
	}

	public static class CarTOBuilder {
		private int idCar;
		private String type;
		private String brand;
		private String model;
		private String color;
		private int engineCapacity;
		private int enginePower;
		private int mileage;
		private int year;
		private List<EmployeeTO> employeeKeeper;

		public CarTOBuilder() {
		}

		public CarTOBuilder(String type, String brand, String model) {
			this.type = type;
			this.brand = brand;
			this.model = model;
		}

		public CarTOBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarTOBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		public CarTOBuilder withEnginePower(int enginePower) {
			this.enginePower = enginePower;
			return this;
		}

		public CarTOBuilder withMileage(int mileage) {
			this.mileage = mileage;
			return this;
		}

		public CarTOBuilder withYear(int year) {
			this.year = year;
			return this;
		}

		public CarTOBuilder withEmployeeKeeper(List<EmployeeTO> employeeKeeper) {
			this.employeeKeeper = employeeKeeper;
			return this;
		}

		public CarTO build() {
			return new CarTO(this);
		}
	}
}