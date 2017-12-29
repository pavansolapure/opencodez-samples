package com.opencodez.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pavan.solapure
 *
 */
public class Consumer implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	private String topic;
	
	public Consumer(String topic) {
		this.topic = topic;
	}

	@Override
	public void run() {
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(this.topic));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				logger.info("offset = {}, value = {}", record.offset(), record.value());
				System.out.println("offset = " + record.offset() + ", value = " + record.value());
			}
		}
		
	}
}
