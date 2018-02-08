package com.opencodez.patterns.strategy;

public class Customer {
	
	private BookingStrategy bookingStrategy;
	
	public Customer(BookingStrategy bs) {
		this.bookingStrategy = bs;
	}
	
	public double calculateFare(int numOfPassangeres) {
		double fare = numOfPassangeres * getBookingStrategy().getFare();
		System.out.println("Calculating fares using " + getBookingStrategy());
		return fare;
	}

	public BookingStrategy getBookingStrategy() {
		return bookingStrategy;
	}

	public void setBookingStrategy(BookingStrategy bookingStrategy) {
		this.bookingStrategy = bookingStrategy;
	}

}
