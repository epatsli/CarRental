package com.capgemini.types;

public class CarTO {

	private int idCar;
	private String type;
	private String brand;
	private String model;
	private String color;
	private int engine_capacity;
	private int engine_power;
	private int mileage;
	private int year;

	public CarTO() {
	}

	public CarTO(CarTOBuilder builder) {
		this.idCar = builder.idCar;
		this.type = builder.type;
		this.brand = builder.brand;
		this.model = builder.model;
		this.color = builder.color;
		this.engine_capacity = builder.engine_capacity;
		this.engine_power = builder.engine_power;
		this.mileage = builder.mileage;
		this.year = builder.year;

	}

	public static CarTOBuilder builder() {
		return new CarTOBuilder();
	}

	public static class CarTOBuilder {
		private int idCar;
		private String type;
		private String brand;
		private String model;
		private String color;
		private int engine_capacity;
		private int engine_power;
		private int mileage;
		private int year;// this.listRentingCar=builder.listRentingCar;this.employeeKeeper=builder.employeeKeeper;

		public CarTOBuilder() {
		}

		public CarTOBuilder(int idCar, String type, String brand, String model) {
			this.idCar = idCar;
			this.type = type;
			this.brand = brand;
			this.model = model;
		}

		public CarTOBuilder color(String color) {
			this.color = color;
			return this;
		}

		public CarTOBuilder engine_capacity(int engine_capacity) {
			this.engine_capacity = engine_capacity;
			return this;
		}

		public CarTOBuilder engine_power(int engine_power) {
			this.engine_power = engine_power;
			return this;
		}

		public CarTOBuilder mileage(int mileage) {
			this.mileage = mileage;
			return this;
		}

		public CarTOBuilder year(int year) {
			this.year = year;
			return this;
		}

		public CarTO build() {
			return new CarTO(this);
		}
	}
}