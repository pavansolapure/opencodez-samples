/**
 * 
 */
package com.opencodez.domain;

/**
 * @author pavan.solapure
 *
 */
public class CsvData {
	
	private String id;
	
	private String name;
	
	private String series;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the series
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getId())
		.append(" | ")
		.append(this.getName())
		.append(" | ")
		.append(this.getSeries());
		return sb.toString();
	}
	
}
