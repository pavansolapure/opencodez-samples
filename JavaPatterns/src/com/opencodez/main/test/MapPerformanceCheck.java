package com.opencodez.main.test;

import java.util.HashMap;

public class MapPerformanceCheck {
	
	private HashMap<Integer, Employee> empHashMap = new HashMap<>();
	private static int mapSize = 10000000;
	
	private void timeinMapPutOp() {
		for(int i=0; i< mapSize; i++) {
			Employee e = new Employee();
			empHashMap.put(i, e);
		}
	}
	
	private void timeinMapGetOp() {
		for(int i=0; i< mapSize; i++) {
			empHashMap.get(i);
		}
	}
	
	public static void main(String args[]) {
		MapPerformanceCheck mpc = new MapPerformanceCheck();
		mpc.timeinMapPutOp();
		mpc.timeinMapGetOp();
	}

}
