package com.opencodez.patterns.observer;

public class Subscriber extends Observer {
	
	private String name;
	
	public Subscriber(String n, Topic t) {
		this.name = n;
		this.topic = t;
		this.topic.subscribe(this);
	}

	@Override
	public void update() {
		System.out.println(name + " new message arrived -> " + this.topic.getMessage());		
	}

	public String getName() {
		return name;
	}
}
