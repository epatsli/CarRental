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
	// ???
	@ManyToMany(mappedBy = "carKeeper", cascade = CascadeType.ALL)
	private List<EmployeeEntity> employeeKeeper = new ArrayList<>();

	public CarEntity() {
	}

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

		public CarEntityBuilder() {
		}

		public CarEntityBuilder withIdCar(Long idCar) {
			this.idCar = idCar;
			return this;
		}

		public CarEntityBuilder withType(String type) {
			this.type = type;
			return this;
		}

		public CarEntityBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public CarEntityBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarEntityBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarEntityBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		public CarEntityBuilder withEnginePower(int enginePower) {
			this.enginePower = enginePower;
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
			checkBeforeBuild();
			return new CarEntity(this);
		}

		private void checkBeforeBuild() {
			if (type == null || brand == null || model == null) {
				throw new RuntimeException("This car can't be created");
			}

		}

	}

}
