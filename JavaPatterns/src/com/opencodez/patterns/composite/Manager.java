package com.opencodez.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {
	
	private String name;
	List<Employee> reportees = new ArrayList<>();
	
	public Manager(String name) {
		this.name = name;
	}
	
	public void addReportee(Employee e) {
		reportees.add(e);
	}
	
	public void remove(Employee e) {
		reportees.remove(e);
	}

	@Override
	public void print() {
		System.out.println(name);
		System.out.println("Reportees..");	
		for(Employee e : reportees) {
			e.print();
		}
	}

}
