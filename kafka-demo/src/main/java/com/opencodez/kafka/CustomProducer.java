package com.opencodez.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencodez.domain.Developer;

/**
 * @author pavan.solapure
 *
 */
public class CustomProducer implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomProducer.class);
	
	private Developer devRecord;
	private String topic;
	
	public CustomProducer(String topic, Developer devRecord) {
		this.devRecord = devRecord;
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
		props.put("value.serializer", "com.opencodez.serializer.DeveloperSerializer");

		KafkaProducer<String, Developer> producer = new KafkaProducer<>(props);
		
		producer.send(new ProducerRecord<String, Developer>(this.topic, this.devRecord));
		
		logger.info("Message sent to topic: {}", this.topic);
		
		producer.close();
	}
}
