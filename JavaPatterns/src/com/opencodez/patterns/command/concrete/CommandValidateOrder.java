package com.opencodez.patterns.command.concrete;

import com.opencodez.patterns.command.Command;
import com.opencodez.patterns.command.receiver.Order;

//Concrete Command
public class CommandValidateOrder implements Command {

	private Order order;
	
	public CommandValidateOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public void execute() {
		this.order.setOrderValidated(true);
		System.out.println(this.order);
	}
	
}
