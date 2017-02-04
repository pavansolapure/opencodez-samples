/**
 * 
 */
package com.opencodez.domain.pagination;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class SortBy.
 *
 * @author pavan.solapure
 */
public class SortBy {
	
	/** The map of sorts. */
	private Map<String, SortOrder> mapOfSorts;
	
	/**
	 * Instantiates a new sort by.
	 */
	public SortBy() {
		if(null == mapOfSorts) {
			mapOfSorts = new HashMap<String, SortOrder>();
		}
	}

	/**
	 * Gets the sort bys.
	 *
	 * @return the sortBys
	 */
	public Map<String, SortOrder>  getSortBys() {
		return mapOfSorts;
	}
	
	/**
	 * Adds the sort.
	 *
	 * @param sortBy the sort by
	 */
	public void addSort(String sortBy) {
		mapOfSorts.put(sortBy, SortOrder.ASC);
	}
	
	/**
	 * Adds the sort.
	 *
	 * @param sortBy the sort by
	 * @param sortOrder the sort order
	 */
	public void addSort(String sortBy, SortOrder sortOrder) {
		mapOfSorts.put(sortBy, sortOrder);
	}

}
