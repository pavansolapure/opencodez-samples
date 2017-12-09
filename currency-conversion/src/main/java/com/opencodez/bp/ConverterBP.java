package com.opencodez.bp;

import java.math.BigDecimal;

import com.opencodez.model.ConverterModel;
import com.opencodez.model.ResponseModel;
import com.opencodez.util.Currency;

public interface ConverterBP {
	
	public ResponseModel getConvertedValue(Currency source, Currency target, BigDecimal amount);
	public ConverterModel getConverterModel();

}
