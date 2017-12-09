package com.opencodez.model;

import java.math.BigDecimal;

public class ResponseModel {
	
	private BigDecimal convertedValue;
	private Error error;
	/**
	 * @return the convertedValue
	 */
	public BigDecimal getConvertedValue() {
		return convertedValue;
	}
	/**
	 * @param convertedValue the convertedValue to set
	 */
	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}
	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}
	
}
