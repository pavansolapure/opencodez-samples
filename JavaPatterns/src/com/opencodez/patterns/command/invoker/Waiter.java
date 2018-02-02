package com.opencodez.patterns.command.invoker;

//Invoker
public class Waiter  extends Invoker  {
	
	@Override
	public void invokeCommand() {
		this.getCommand().execute();
	}
	
	public void takeOrder() {
		invokeCommand();
	}
	
	public void serveOrder() {
		invokeCommand();
	}	
}
