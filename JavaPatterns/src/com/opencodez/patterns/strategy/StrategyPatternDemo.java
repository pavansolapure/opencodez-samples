package com.opencodez.patterns.strategy;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		
		//CarBooking Strategy
		Customer cust = new Customer(new CarBookingStrategy());
		double fare = cust.calculateFare(5);
		System.out.println(fare);
		
		//TrainBooking Strategy
		cust.setBookingStrategy(new TrainBookingStrategy());
		fare = cust.calculateFare(5);
		System.out.println(fare);
		
		//TrainBooking Strategy
		cust.setBookingStrategy(new BusBookingStrategy());
		fare = cust.calculateFare(5);
		System.out.println(fare);

	}

}
