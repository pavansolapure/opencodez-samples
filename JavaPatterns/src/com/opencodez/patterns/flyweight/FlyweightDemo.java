package com.opencodez.patterns.flyweight;

public class FlyweightDemo {

	// Tea array
	private static Tea[] Teas = new Tea[20];
	
	// table array
	private static TeaContext[] tables = new TeaContext[20];
	private static int ordersCount = 0;
	private static TeaFactory teaFactory;

	public static void takeOrder(String flavorIn, int table) {
		Teas[ordersCount] = teaFactory.getTeaFlavor(flavorIn);
		tables[ordersCount] = new TeaContext(table);
		ordersCount++;
	}

	public static void main(String[] args) {
		teaFactory = new TeaFactory();
		takeOrder("GreenTea", 2);
		takeOrder("GreenTea", 2);
		takeOrder("Regular Tea", 1);
		takeOrder("Ginger Tea", 2);
		takeOrder("Regular Tea", 3);
		takeOrder("Regular Tea", 4);
		takeOrder("GreenTea", 4);
		takeOrder("GreenTea", 5);
		takeOrder("Ginger Tea", 3);
		takeOrder("GreenTea", 3);
		for (int i = 0; i < ordersCount; ++i) {
			Teas[i].serveTea(tables[i]);
		}
		System.out.println("\nTotal Tea(Types of Tea) objects created: " + teaFactory.getTotalTeaFlavorsMade());
	}

}
