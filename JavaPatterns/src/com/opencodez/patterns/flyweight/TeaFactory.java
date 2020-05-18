package com.opencodez.patterns.flyweight;

import java.util.HashMap;

public class TeaFactory {
	
	private HashMap<String, Tea> flavors = new HashMap<String, Tea>();

	public Tea getTeaFlavor(String flavorName) {
		Tea flavor = flavors.get(flavorName);
		if (flavor == null) {
			flavor = new Tea(flavorName);
			flavors.put(flavorName, flavor);
		}
		return flavor;
	}

	public int getTotalTeaFlavorsMade() {
		return flavors.size();
	}
}
