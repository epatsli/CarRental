package com.capgemini.types;

import java.util.List;

/**
 * This class contains car dates.
 *
 */
public class CarTO {

	private Long idCar;
	private String type;
	private String brand;
	private String model;
	private String color;
	private int engineCapacity;
	private int enginePower;
	private int mileage;
	private int year;
	private List<EmployeeTO> employeeKeeper;
	private List<RentingCarTO> listRentingCar;

	/**
	 * No-argument constructor
	 */
	public CarTO() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
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
		this.listRentingCar = builder.listRentingCar;

	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public static CarTOBuilder builder() {
		return new CarTOBuilder();
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
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

	public List<RentingCarTO> getListRentingCar() {
		return listRentingCar;
	}

	public void setListRentingCar(List<RentingCarTO> listRentingCar) {
		this.listRentingCar = listRentingCar;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class CarTOBuilder {
		private Long idCar;
		private String type;
		private String brand;
		private String model;
		private String color;
		private int engineCapacity;
		private int enginePower;
		private int mileage;
		private int year;
		private List<RentingCarTO> listRentingCar;
		private List<EmployeeTO> employeeKeeper;

		/**
		 * No-argument constructor
		 */
		public CarTOBuilder() {
		}

		/**
		 * This method set car type.
		 * 
		 * @param type
		 *            car type
		 * @return new object with car type
		 */
		public CarTOBuilder withType(String type) {
			this.type = type;
			return this;
		}

		/**
		 * This method set car brand.
		 * 
		 * @param brand
		 *            car brand
		 * @return new object with car brand
		 */
		public CarTOBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		/**
		 * This method set car model.
		 * 
		 * @param model
		 *            car model
		 * @return new object with car model
		 */
		public CarTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		/**
		 * This method set the color of the car.
		 * 
		 * @param color
		 *            color of the car
		 * @return new object with color of the car
		 */
		public CarTOBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		/**
		 * This method sat engine capacity.
		 * 
		 * @param engineCapacity
		 *            capacity of the car engine
		 * @return new object with capacity of the car engine
		 */
		public CarTOBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		/**
		 * 
		 * This method set power engine.
		 * 
		 * @param enginePower
		 *            power of the car engine
		 * @return new object with power of the car engine
		 */
		public CarTOBuilder withEnginePower(int enginePower) {
			this.enginePower = enginePower;
			return this;
		}

		/**
		 * This method set mileage.
		 * 
		 * @param mileage
		 *            car mileage
		 * @return new object with car mileage
		 */
		public CarTOBuilder withMileage(int mileage) {
			this.mileage = mileage;
			return this;
		}

		/**
		 * This method set car year.
		 * 
		 * @param year
		 *            production year
		 * @return new object with production year
		 */
		public CarTOBuilder withYear(int year) {
			this.year = year;
			return this;
		}

		/**
		 * This method set list of rentals for this car.
		 * 
		 * @param listRentingCar
		 *            list of rentals
		 * @return new object with list of rentals
		 */
		public CarTOBuilder withListRentingCar(List<RentingCarTO> listRentingCar) {
			this.listRentingCar = listRentingCar;
			return this;
		}

		/**
		 * This method set list car keepers.
		 * 
		 * @param employeeKeeper
		 *            list of car keepers
		 * @return new object with list car keepers
		 */
		public CarTOBuilder withEmployeeKeeper(List<EmployeeTO> employeeKeeper) {
			this.employeeKeeper = employeeKeeper;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object car
		 */
		public CarTO build() {
			return new CarTO(this);
		}
	}
}