package com.opencodez.patterns.prototype;

public class PrototypeTest {

	public static void main(String a[]) {
		CarStore.getCar("Toyota").modelname();
		CarStore.getCar("Maruti").modelname();
		CarStore.getCar("Maruti").modelname();
		CarStore.getCar("Toyota").modelname();
	}
}
