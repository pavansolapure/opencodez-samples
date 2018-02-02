package com.opencodez.patterns.command.client;

import com.opencodez.patterns.command.concrete.CommandCookOrder;
import com.opencodez.patterns.command.concrete.CommandPlaceOrder;
import com.opencodez.patterns.command.concrete.CommandServeOrder;
import com.opencodez.patterns.command.concrete.CommandValidateOrder;
import com.opencodez.patterns.command.invoker.Cook;
import com.opencodez.patterns.command.invoker.Manager;
import com.opencodez.patterns.command.invoker.Waiter;
import com.opencodez.patterns.command.receiver.Order;

//Client
public class ClientCustomer {
	
	public ClientCustomer() {

		Order myOrder = new Order("Veg Burger", 2);
		
		
		//Place Order
		CommandPlaceOrder cmdPlaceOrder = new CommandPlaceOrder(myOrder);
		
		Waiter waiter = new Waiter();
		waiter.setCommand(cmdPlaceOrder);
		waiter.takeOrder();
		
		
		//Validate Order
		CommandValidateOrder cmdValidateOrder = new CommandValidateOrder(myOrder);
		
		Manager manager = new Manager();
		manager.setCommand(cmdValidateOrder);
		manager.validateOrder();
		
		CommandCookOrder cmdCookOrder = new CommandCookOrder(myOrder);
		
		Cook cook = new Cook();
		cook.setCommand(cmdCookOrder);
		cook.prepareOrder();
		

		CommandServeOrder cmdServeOrder = new CommandServeOrder(myOrder);
		
		waiter.setCommand(cmdServeOrder);
		waiter.serveOrder();
	}

}
