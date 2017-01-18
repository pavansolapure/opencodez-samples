/**
 * 
 */
package com.opencodez.util.csv;

import com.opencodez.domain.CsvData;

/**
 * @author pavan.solapure
 *
 */
public class CustomCsvProcessor implements CsvProcessor<CsvData> {

	@Override
	public CsvData process(CsvData inData) {
		inData.setName(inData.getName().toUpperCase());
		return inData;
	}
}
