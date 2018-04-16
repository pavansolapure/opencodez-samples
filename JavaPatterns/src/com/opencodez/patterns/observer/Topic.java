package com.opencodez.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic {

	private List<Subscriber> subscribers = new ArrayList<>();
	private String topicName;
	private String message;

	public Topic(String name) {
		this.topicName = name;
	}

	public void subscribe(Subscriber s) {
		subscribers.add(s);
	}

	public void publish(String message) {
		this.message = message;
		notifySubscribers();
	}

	public void notifySubscribers() {
		for (Subscriber sub : subscribers) {
			sub.update();
		}
	}

	public String getTopicName() {
		return topicName;
	}

	public String getMessage() {
		return message;
	}
}
