package com.opencodez.patterns.prototype;

public abstract class Car implements Cloneable {

	protected String carName;

	abstract void modelname();

	public Object clone() {

		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
