/**
 * 
 */
package com.example.dao;

import java.util.List;

import com.example.entity.Example;


/**
 * The Interface GenericRepository.
 *
 * @author pavan.solapure
 */

public interface GenericRepository {

	public List<Example> getExamples();
	
	public void saveExample(Example ex);
	
}
