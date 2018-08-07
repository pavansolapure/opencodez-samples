/**
 * 
 */
package com.opencodez.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pavan.solapure
 *
 */
@Entity
@Table(name = "MYUSERS")
public class User {

	@Id
	@Column(name = "USER_ID")
	private Long id;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "SALARY")
	private String salary;

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
//	/**
//	 * @return the totalRecords
//	 */
//	public Integer getTotalRecords() {
//		return totalRecords;
//	}
//	/**
//	 * @param totalRecords the totalRecords to set
//	 */
//	public void setTotalRecords(Integer totalRecords) {
//		this.totalRecords = totalRecords;
//	}
}
