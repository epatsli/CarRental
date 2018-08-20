package com.capgemini.domain;

public class SearchCriteria {
	private Long idInstitution;
	private Long idCar;
	private Long idPosition;

	/**
	 * Constructor create new object with builder.
	 * 
	 * @param builder
	 */
	public SearchCriteria(SearchCriteriaBuilder builder) {
		this.idInstitution = builder.idInstitution;
		this.idCar = builder.idCar;
		this.idPosition = builder.idPosition;
	}

	public Long getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Long idInstitution) {
		this.idInstitution = idInstitution;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public Long getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(Long idPosition) {
		this.idPosition = idPosition;
	}

	/**
	 * This method create new object.
	 * 
	 * @return new object
	 */
	public static SearchCriteriaBuilder builder() {
		return new SearchCriteriaBuilder();
	}

	/**
	 * This is builder class.
	 *
	 */
	public static class SearchCriteriaBuilder {

		private Long idInstitution;
		private Long idCar;
		private Long idPosition;

		/**
		 * This method set index institution.
		 * 
		 * @param idInstitution
		 *            index institution
		 * @return new object with institution index
		 */
		public SearchCriteriaBuilder withIdInstitution(Long idInstitution) {
			this.idInstitution = idInstitution;
			return this;
		}

		/**
		 * This method set car index.
		 * 
		 * @param idCar
		 *            index car
		 * @return new object with car index
		 */
		public SearchCriteriaBuilder withIdCar(Long idCar) {
			this.idCar = idCar;
			return this;
		}

		/**
		 * This method set position index.
		 * 
		 * @param idPosition
		 *            index position
		 * @return new object with position index
		 */
		public SearchCriteriaBuilder withIdPosition(Long idPosition) {
			this.idPosition = idPosition;
			return this;
		}

		/**
		 * This method create new object.
		 * 
		 * @return new object search criteria
		 */
		public SearchCriteria build() {
			return new SearchCriteria(this);

		}
	}

}
