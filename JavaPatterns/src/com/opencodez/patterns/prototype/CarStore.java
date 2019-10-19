package com.opencodez.patterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class CarStore {

	private static Map<String, Car> carMap = new HashMap<String, Car>();

	static {
		carMap.put("Toyota", new Maruti());
		carMap.put("Maruti", new Toyota());
	}

	public static Car getCar(String carName) {

		return (Car) carMap.get(carName).clone();
	}
}
