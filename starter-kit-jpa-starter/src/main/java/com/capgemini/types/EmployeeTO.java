package com.capgemini.types;

import java.util.List;

import com.capgemini.embedded.PersonDataTO;

public class EmployeeTO {
	private Long idEmployee;
	private PersonDataTO person;
	private PositionTO position;
	private InstitutionTO institutionEmployee;
	private List<CarTO> carKeeper;

	public EmployeeTO() {
	}

	public EmployeeTO(EmployeeTOBuilder builder) {
		this.idEmployee = builder.idEmployee;
		this.person = builder.person;
		this.position = builder.position;
		this.institutionEmployee = builder.institutionEmployee;
		this.carKeeper = builder.carKeeper;
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

	public static class EmployeeTOBuilder {
		private Long idEmployee;
		private PersonDataTO person;
		private PositionTO position;
		private InstitutionTO institutionEmployee;
		private List<CarTO> carKeeper;

		public EmployeeTOBuilder() {
		}

		public EmployeeTOBuilder withIdEmployee(Long idEmployee) {
			this.idEmployee = idEmployee;
			return this;
		}

		public EmployeeTOBuilder withPerson(PersonDataTO person) {
			this.person = person;
			return this;
		}

		public EmployeeTOBuilder withPosition(PositionTO position) {
			this.position = position;
			return this;
		}

		public EmployeeTOBuilder withInstitutionEmployee(InstitutionTO institutionEmployee) {
			this.institutionEmployee = institutionEmployee;
			return this;
		}

		public EmployeeTOBuilder withCarKeeper(List<CarTO> carKeeper) {
			this.carKeeper = carKeeper;
			return this;
		}

		public EmployeeTO builder() {
			return new EmployeeTO(this);
		}

	}

}
