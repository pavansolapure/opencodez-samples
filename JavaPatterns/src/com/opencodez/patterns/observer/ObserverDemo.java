package com.opencodez.patterns.observer;

public class ObserverDemo {

	public static void main(String[] args) {
		
		Topic t = new Topic("opencodez");
		
		new Subscriber("Sub 1", t);
		new Subscriber("Sub 2", t);
		
		t.publish("Hello for topic Subscribers");
		
		new Subscriber("Sub 3", t);
		
		t.publish("Hello again for topic Subscribers");
		
	}

}
