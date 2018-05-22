package com.opencodez.main.test;

public class Employee {
	public String name = "opencodez";

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		return this.name.equals(e.name);
	}
}
