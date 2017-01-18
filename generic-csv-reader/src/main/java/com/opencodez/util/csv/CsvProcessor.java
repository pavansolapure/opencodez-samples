/**
 * 
 */
package com.opencodez.util.csv;

/**
 * @author pavan.solapure
 *
 */
public interface CsvProcessor<T> {
	public T process(T inData);
}
