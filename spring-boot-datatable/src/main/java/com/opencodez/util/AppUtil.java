/**
 * 
 */
package com.opencodez.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.opencodez.domain.pagination.PaginationCriteria;

/**
 * The Class AppUtil.
 *
 * @author pavan.solapure
 */
public class AppUtil {
	
	/**
	 * Checks if is collection empty.
	 *
	 * @param collection the collection
	 * @return true, if is collection empty
	 */
	private static boolean isCollectionEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if is object empty.
	 *
	 * @param object the object
	 * @return true, if is object empty
	 */
	public static boolean isObjectEmpty(Object object) {
		if(object == null) return true;
		else if(object instanceof String) {
			if (((String)object).trim().length() == 0) {
				return true;
			}
		} else if(object instanceof Collection) {
			return isCollectionEmpty((Collection<?>)object);
		}
		return false;
	}
	
	/**
	 * Gets the bean to json string.
	 *
	 * @param beanClass the bean class
	 * @return the bean to json string
	 */
	public static String getBeanToJsonString(Object beanClass) {
		return new Gson().toJson(beanClass);
	}
	
	/**
	 * Gets the bean to json string.
	 *
	 * @param beanClasses the bean classes
	 * @return the bean to json string
	 */
	public static String getBeanToJsonString(Object... beanClasses) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Object beanClass : beanClasses) {
			stringBuilder.append(getBeanToJsonString(beanClass));
			stringBuilder.append(", ");
		}
		return stringBuilder.toString();
	}

	/**
	 * Concatenate.
	 *
	 * @param listOfItems the list of items
	 * @param separator the separator
	 * @return the string
	 */
	public String concatenate(List<String> listOfItems, String separator) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> stit = listOfItems.iterator();
		
		while (stit.hasNext()) {
			sb.append(stit.next());
			if(stit.hasNext()) {
				sb.append(separator);
			}
		}
		
		return sb.toString();		
	}
	
	/**
	 * Builds the paginated query.
	 *
	 * @param baseQuery the base query
	 * @param paginationCriteria the pagination criteria
	 * @return the string
	 */
	public static String buildPaginatedQuery(String baseQuery, PaginationCriteria paginationCriteria) {
		//String queryTemplate = "SELECT FILTERED_ORDERD_RESULTS.* FROM (SELECT BASEINFO.* FROM ( %s ) BASEINFO %s  %s ) FILTERED_ORDERD_RESULTS LIMIT %d, %d";
		StringBuilder sb = new StringBuilder("SELECT FILTERED_ORDERD_RESULTS.* FROM (SELECT BASEINFO.* FROM ( #BASE_QUERY# ) BASEINFO #WHERE_CLAUSE#  #ORDER_CLASUE# ) FILTERED_ORDERD_RESULTS LIMIT #PAGE_NUMBER#, #PAGE_SIZE#");
		String finalQuery = null;
		if(!AppUtil.isObjectEmpty(paginationCriteria)) {
			finalQuery = sb.toString().replaceAll("#BASE_QUERY#", baseQuery)
							.replaceAll("#WHERE_CLAUSE#", ((AppUtil.isObjectEmpty(paginationCriteria.getFilterByClause())) ? "" : " WHERE ") + paginationCriteria.getFilterByClause())
								.replaceAll("#ORDER_CLASUE#", paginationCriteria.getOrderByClause())
									.replaceAll("#PAGE_NUMBER#", paginationCriteria.getPageNumber().toString())
										.replaceAll("#PAGE_SIZE#", paginationCriteria.getPageSize().toString());
		}
		return (null == finalQuery) ?  baseQuery : finalQuery;
	}
	
	public static String buildPaginatedQueryForOracle(String baseQuery, PaginationCriteria paginationCriteria) {
		
		StringBuilder sb = new StringBuilder("SELECT * FROM (SELECT FILTERED_ORDERED_RESULTS.*, COUNT(1) OVER() total_records, ROWNUM AS RN FROM (SELECT BASEINFO.* FROM ( #BASE_QUERY# ) BASEINFO ) FILTERED_ORDERED_RESULTS #WHERE_CLAUSE# #ORDER_CLASUE# ) WHERE RN > (#PAGE_NUMBER# * #PAGE_SIZE#) AND RN <= (#PAGE_NUMBER# + 1) * #PAGE_SIZE# ");
		String finalQuery = null;
		
		//Datatable start is set to 0, 5, 10 ..etc (5 is page size)
		//For oracle paginated query we need page start from 1,2,3
		
		int pageNo = paginationCriteria.getPageNumber() / paginationCriteria.getPageSize();
		paginationCriteria.setPageNumber(pageNo);
		
		if(!AppUtil.isObjectEmpty(paginationCriteria)) {
			finalQuery = sb.toString().replaceAll("#BASE_QUERY#", baseQuery)
							.replaceAll("#WHERE_CLAUSE#", ((AppUtil.isObjectEmpty(paginationCriteria.getFilterByClause())) ? "" : " WHERE ") + paginationCriteria.getFilterByClause())
								.replaceAll("#ORDER_CLASUE#", paginationCriteria.getOrderByClause())
									.replaceAll("#PAGE_NUMBER#", paginationCriteria.getPageNumber().toString())
										.replaceAll("#PAGE_SIZE#", paginationCriteria.getPageSize().toString());
		}
		return (null == finalQuery) ?  baseQuery : finalQuery;
	}
}
