package com.opencodez.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {
	
	@Id
	private Long userId;
	
	private String name;
	
	private String dept;
	
	private BigDecimal account;
}
