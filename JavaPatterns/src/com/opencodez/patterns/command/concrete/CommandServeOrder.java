package com.opencodez.patterns.command.concrete;

import com.opencodez.patterns.command.Command;
import com.opencodez.patterns.command.receiver.Order;

//Concrete Command
public class CommandServeOrder implements Command {

	private Order order;
	
	public CommandServeOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public void execute() {
		this.order.setOrderServed(true);
		System.out.println(this.order);
	}

}
