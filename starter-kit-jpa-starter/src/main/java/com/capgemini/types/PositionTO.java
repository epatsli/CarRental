package com.capgemini.types;

import java.util.List;

public class PositionTO {

	private Long idPosition;
	private String namePosition;
	private List<EmployeeTO> listEmployee;

	public PositionTO() {
	}

	public PositionTO(PositionTOBuilder build) {
		this.idPosition = build.idPosition;
		this.namePosition = build.namePosition;
		this.listEmployee = build.listEmployee;
	}

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

	public static class PositionTOBuilder {
		private Long idPosition;
		private String namePosition;
		private List<EmployeeTO> listEmployee;

		public PositionTOBuilder() {
		}

		public PositionTOBuilder withIdPosition(Long idPosition) {
			this.idPosition = idPosition;
			return this;
		}

		public PositionTOBuilder withNamePosition(String namePosition) {
			this.namePosition = namePosition;
			return this;
		}

		public PositionTOBuilder withListEmployee(List<EmployeeTO> listEmployee) {
			this.listEmployee = listEmployee;
			return this;
		}

		public PositionTO build() {
			checkBeforeBuild();
			return new PositionTO();
		}

		private void checkBeforeBuild() {
			if (namePosition == null || namePosition.isEmpty()) {
				throw new RuntimeException("Incorrect author to be created");
			}

		}
	}
}
