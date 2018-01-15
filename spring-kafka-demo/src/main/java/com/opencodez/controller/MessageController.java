package com.opencodez.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class MessageController {
	
	private final List<SseEmitter> emitters = new ArrayList<>();
	
	@GetMapping("/kafka-messages")
	public SseEmitter getKafkaMessages() {
		
		SseEmitter emitter = new SseEmitter( 1 * 60 * 1000L );
		emitters.add(emitter);
		
		emitter.onCompletion(new Runnable() {
			@Override
			public void run() {
				emitters.remove(emitter);
			}
		});
		
		emitter.onTimeout(new Runnable() {
			@Override
			public void run() {
				emitters.remove(emitter);
			}
		});
		
		return emitter;
	}
	
	public List<SseEmitter> getEmitters() {
		return emitters;
	}
	
	public SseEmitter getLatestEmitter() {
		return (emitters.isEmpty()) ? null : emitters.get(emitters.size()-1);
	}

}
