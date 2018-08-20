package com.capgemini.domain;

import java.io.Serializable;
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

import com.capgemini.exception.IncorrectParameterException;

/**
 * This class maps car tables.
 *
 */
@Entity
@Table(name = "CARS")
public class CarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCar;

	@Column(name = "type", length = 32, nullable = false)
	private String type;

	@Column(name = "brand", length = 32, nullable = false)
	private String brand;

	@Column(name = "model", length = 32, nullable = false)
	private String model;

	@Column(name = "color", length = 32)
	private String color;

	@Column(name = "engineCapacity")
	private int engineCapacity;

	@Column(name = "enginePower")
	private int enginePower;

	@Column(name = "mileage")
	private int mileage;

	@Column(name = "year")
	private int year;

	@OneToMany(mappedBy = "car", cascade = CascadeType.PERSIST)
	private List<RentingCarEntity> listRentingCar = new ArrayList<>();

	@ManyToMany(mappedBy = "carKeeper", cascade = CascadeType.ALL)
	private List<EmployeeEntity> employeeKeeper = new ArrayList<>();

	/**
	 * No-argument constructor
	 */
	public CarEntity() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public CarEntity(CarEntityBuilder builder) {
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
		this.employeeKeeper = builder.employeeKeeper;
	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public CarEntityBuilder builder() {
		return new CarEntityBuilder();
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

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
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

	/**
	 * This is builder class.
	 *
	 */
	public static class CarEntityBuilder {
		private Long idCar;
		private String type;
		private String brand;
		private String model;
		private String color;
		private int engineCapacity;
		private int enginePower;
		private int mileage;
		private int year;
		private List<RentingCarEntity> listRentingCar;
		private List<EmployeeEntity> employeeKeeper;

		/**
		 * No-argument constructor
		 */
		public CarEntityBuilder() {
		}

		/**
		 * This method set car index.
		 * 
		 * @param idCar
		 *            car index
		 * @return new object with car index
		 */
		public CarEntityBuilder withIdCar(Long idCar) {
			this.idCar = idCar;
			return this;
		}

		/**
		 * This method set car type.
		 * 
		 * @param type
		 *            car type
		 * @return new object with car type
		 */
		public CarEntityBuilder withType(String type) {
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
		public CarEntityBuilder withBrand(String brand) {
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
		public CarEntityBuilder withModel(String model) {
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
		public CarEntityBuilder withColor(String color) {
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
		public CarEntityBuilder withEngineCapacity(int engineCapacity) {
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
		public CarEntityBuilder withEnginePower(int enginePower) {
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
		public CarEntityBuilder withMileage(int mileage) {
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
		public CarEntityBuilder withYear(int year) {
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
		public CarEntityBuilder withListRentingCar(List<RentingCarEntity> listRentingCar) {
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
		public CarEntityBuilder withEmployeeKeeper(List<EmployeeEntity> employeeKeeper) {
			this.employeeKeeper = employeeKeeper;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object car
		 */
		public CarEntity build() {
			checkBeforeBuild();
			return new CarEntity(this);
		}

		private void checkBeforeBuild() {
			if (type == null || brand == null || model == null) {
				throw new IncorrectParameterException("This car can't be created");
			}

		}

	}

}
