package com.opencodez.patterns.command.invoker;

//Invoker
public class Cook extends Invoker {

	@Override
	public void invokeCommand() {
		this.getCommand().execute();
	}
	
	public void prepareOrder() {
		invokeCommand();
	}	
}
