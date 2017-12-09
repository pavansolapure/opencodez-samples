package com.opencodez.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.opencodez.util.Currency;

public class ConverterModel {
	
	private Currency srcCurrency;
	
	private Currency tgtCurrency;
	
	private BigDecimal srcAmount;
	
	private BigDecimal tgtAmount;

	
	/**
	 * @return the srcCurrency
	 */
	public Currency getSrcCurrency() {
		return srcCurrency;
	}

	/**
	 * @param srcCurrency the srcCurrency to set
	 */
	public void setSrcCurrency(Currency srcCurrency) {
		this.srcCurrency = srcCurrency;
	}

	/**
	 * @return the tgtCurrency
	 */
	public Currency getTgtCurrency() {
		return tgtCurrency;
	}

	/**
	 * @param tgtCurrency the tgtCurrency to set
	 */
	public void setTgtCurrency(Currency tgtCurrency) {
		this.tgtCurrency = tgtCurrency;
	}

	/**
	 * @return the srcAmount
	 */
	public BigDecimal getSrcAmount() {
		return srcAmount;
	}

	/**
	 * @param srcAmount the srcAmount to set
	 */
	public void setSrcAmount(BigDecimal srcAmount) {
		this.srcAmount = srcAmount;
	}

	/**
	 * @return the tgtAmount
	 */
	public BigDecimal getTgtAmount() {
		return tgtAmount;
	}

	/**
	 * @param tgtAmount the tgtAmount to set
	 */
	public void setTgtAmount(BigDecimal tgtAmount) {
		this.tgtAmount = tgtAmount;
	}

	public List<Currency> getSupportedCurrencies() {
		return Arrays.asList(Currency.values());
	}

}
