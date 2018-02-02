package com.opencodez.patterns.command.invoker;

import com.opencodez.patterns.command.Command;

public abstract class Invoker {
	
	//Name of Waiter, Manager etc
	private String name;
	
	//Command to invoke
	private Command command;
	
	public abstract void invokeCommand();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(Command command) {
		this.command = command;
	}  
}
