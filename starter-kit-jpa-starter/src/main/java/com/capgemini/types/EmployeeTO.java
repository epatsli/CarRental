package com.capgemini.types;

import java.util.List;

public class EmployeeTO {
	private Long idEmployee;
	private PersonDataTO person;
	private PositionTO position;
	private InstitutionTO institutionEmployee;
	private List<CarTO> carKeeper;

	/**
	 * No-argument constructor
	 */
	public EmployeeTO() {
	}

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public EmployeeTO(EmployeeTOBuilder builder) {
		this.idEmployee = builder.idEmployee;
		this.person = builder.person;
		this.position = builder.position;
		this.institutionEmployee = builder.institutionEmployee;
		this.carKeeper = builder.carKeeper;
	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public EmployeeTOBuilder builder() {
		return new EmployeeTOBuilder();
	}

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public PersonDataTO getPerson() {
		return person;
	}

	public void setPerson(PersonDataTO person) {
		this.person = person;
	}

	public PositionTO getPosition() {
		return position;
	}

	public void setPosition(PositionTO position) {
		this.position = position;
	}

	public InstitutionTO getInstitutionEmployee() {
		return institutionEmployee;
	}

	public void setInstitutionEmployee(InstitutionTO institutionEmployee) {
		this.institutionEmployee = institutionEmployee;
	}

	public List<CarTO> getCarKeeper() {
		return carKeeper;
	}

	public void setCarKeeper(List<CarTO> carKeeper) {
		this.carKeeper = carKeeper;
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class EmployeeTOBuilder {
		private Long idEmployee;
		private PersonDataTO person;
		private PositionTO position;
		private InstitutionTO institutionEmployee;
		private List<CarTO> carKeeper;

		/**
		 * No-argument constructor
		 */
		public EmployeeTOBuilder() {
		}

		/**
		 * This method set index employee.
		 * 
		 * @param idEmployee
		 *            index employee
		 * @return new object with index
		 */
		public EmployeeTOBuilder withIdEmployee(Long idEmployee) {
			this.idEmployee = idEmployee;
			return this;
		}

		/**
		 * This method set personal data.
		 * 
		 * @param person
		 *            personal date employee
		 * @return new object with personal date employee
		 */
		public EmployeeTOBuilder withPerson(PersonDataTO person) {
			this.person = person;
			return this;
		}

		/**
		 * This method set position employee.
		 * 
		 * @param position
		 *            position employee in factory
		 * @return new object with position employee
		 */
		public EmployeeTOBuilder withPosition(PositionTO position) {
			this.position = position;
			return this;
		}

		/**
		 * This method set work place for employee.
		 * 
		 * @param institutionEmployee
		 *            work place employee
		 * @return new object with work place
		 */
		public EmployeeTOBuilder withInstitutionEmployee(InstitutionTO institutionEmployee) {
			this.institutionEmployee = institutionEmployee;
			return this;
		}

		/**
		 * This method set list of cars that employee looks after
		 * 
		 * @param carKeeper
		 *            list of cars
		 * @return new object with list of cars
		 */
		public EmployeeTOBuilder withCarKeeper(List<CarTO> carKeeper) {
			this.carKeeper = carKeeper;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object employee
		 */
		public EmployeeTO build() {
			return new EmployeeTO(this);
		}

	}

}
