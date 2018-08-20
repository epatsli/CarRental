package com.capgemini.types;

import java.util.List;

import com.capgemini.exception.IncorrectParameterException;

public class PositionTO {

	private Long idPosition;
	private String namePosition;
	private List<EmployeeTO> listEmployee;

	/**
	 * No-argument constructor
	 */
	public PositionTO() {
	}

	/**
	 * Constructor with three parameters.
	 * 
	 * @param idPosition
	 *            index of position
	 * @param namePosition
	 *            name of position
	 * @param listEmployee
	 *            list of employee which have specific position
	 */
	public PositionTO(PositionTOBuilder build) {
		this.idPosition = build.idPosition;
		this.namePosition = build.namePosition;
		this.listEmployee = build.listEmployee;
	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public PositionTOBuilder builder() {
		return new PositionTOBuilder();
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

	public List<EmployeeTO> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<EmployeeTO> listEmployee) {
		this.listEmployee = listEmployee;
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class PositionTOBuilder {
		private Long idPosition;
		private String namePosition;
		private List<EmployeeTO> listEmployee;

		/**
		 * No-argument constructor
		 */
		public PositionTOBuilder() {
		}

		/**
		 * This method set idPosition.
		 * 
		 * @param idPosition
		 *            index position
		 * @return new object with index position
		 */
		public PositionTOBuilder withIdPosition(Long idPosition) {
			this.idPosition = idPosition;
			return this;
		}

		/**
		 * This method set name of position.
		 * 
		 * @param namePosition
		 *            name of position
		 * @return new object with name of position
		 */
		public PositionTOBuilder withNamePosition(String namePosition) {
			this.namePosition = namePosition;
			return this;
		}

		/**
		 * This method set list employees.
		 * 
		 * @param listEmployee
		 *            list of employee
		 * @return new object with list of employees
		 */
		public PositionTOBuilder withListEmployee(List<EmployeeTO> listEmployee) {
			this.listEmployee = listEmployee;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object position
		 */
		public PositionTO build() {
			checkBeforeBuild();
			return new PositionTO();
		}

		private void checkBeforeBuild() {
			if (namePosition == null || namePosition.isEmpty()) {
				throw new IncorrectParameterException("Incorrect author to be created");
			}

		}
	}
}
