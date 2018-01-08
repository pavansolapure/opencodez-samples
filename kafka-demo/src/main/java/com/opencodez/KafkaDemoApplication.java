package com.opencodez;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.opencodez.domain.Address;
import com.opencodez.domain.Developer;
import com.opencodez.kafka.Consumer;
import com.opencodez.kafka.CustomConsumer;
import com.opencodez.kafka.CustomProducer;
import com.opencodez.kafka.Producer;
import com.opencodez.util.Constants;

@SpringBootApplication
public class KafkaDemoApplication implements ApplicationRunner {

	@Autowired
	private TaskExecutor taskExecutor;

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Bean
	public TaskExecutor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		String start_as;
		String topic;
		String msg = null;

		if (args.containsOption(Constants.OPTION_START_AS)) {

			start_as = args.getOptionValues(Constants.OPTION_START_AS).get(0);

			if (args.containsOption(Constants.OPTION_TOPIC)) {

				topic = args.getOptionValues(Constants.OPTION_TOPIC).get(0);
				
				if (args.containsOption(Constants.OPTION_MESSAGE)) {
					msg = args.getOptionValues(Constants.OPTION_MESSAGE).get(0);
				}

				switch (start_as) {
				case Constants.OPTION_CONSUMER:
					taskExecutor.execute(new Consumer(topic));
					break;
				case Constants.OPTION_CUSTOM_CONSUMER:
					taskExecutor.execute(new CustomConsumer(topic));
					break;
				case Constants.OPTION_PRODUCER:
					taskExecutor.execute(new Producer(topic, msg));
					break;
				case Constants.OPTION_CUSTOM_PRODUCER:
					taskExecutor.execute(new CustomProducer(topic, getDummyDeveloper(msg)));
					break;
				}
			}
		}

	}

	private Developer getDummyDeveloper(String msg) {
		Developer d = new Developer();
		d.setId(1298L);
		d.setName(msg);
		d.setSalary(new BigDecimal("123.45"));
		Address a = new Address();
		a.setCountry("India");
		a.setState("Maharashtra");
		a.setZipcode("411028");
		d.setAddress(a);
		return d;
	}
}
