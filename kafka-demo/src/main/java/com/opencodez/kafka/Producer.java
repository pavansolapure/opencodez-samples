package com.opencodez.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pavan.solapure
 *
 */
public class Producer implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	private String message;
	private String topic;
	
	public Producer(String topic, String message) {
		this.message = message;
		this.topic = topic;
	}

	@Override
	public void run() {
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		
		producer.send(new ProducerRecord<String, String>(this.topic, this.message));
		
		logger.info("Message sent to topic: {}", this.topic);
		
		producer.close();
	}
}
