package com.opencodez.patterns.strategy;

public class BusBookingStrategy implements BookingStrategy {

	@Override
	public double getFare() {
		return 5.5;
	}

	@Override
	public String toString(){
		return "BusBookingStrategy";
	}
}
