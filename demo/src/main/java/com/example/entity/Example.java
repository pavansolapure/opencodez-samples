package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "example")
@XmlRootElement(name="Example",namespace="")
public class Example {

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "ex_id", unique = true, nullable = false)
	private Long exId;

	@Column(name = "ex_value")
	private Long exValue;

	/**
	 * @return the exId
	 */
	public Long getExId() {
		return exId;
	}

	/**
	 * @param exId the exId to set
	 */
	public void setExId(Long exId) {
		this.exId = exId;
	}

	/**
	 * @return the exValue
	 */
	public Long getExValue() {
		return exValue;
	}

	/**
	 * @param exValue the exValue to set
	 */
	public void setExValue(Long exValue) {
		this.exValue = exValue;
	}

	
}