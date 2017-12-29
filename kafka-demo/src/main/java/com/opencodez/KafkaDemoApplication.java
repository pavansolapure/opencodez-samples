package com.opencodez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.opencodez.kafka.Consumer;
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
		String msg;

		if (args.containsOption(Constants.OPTION_START_AS)) {
			
			start_as = args.getOptionValues(Constants.OPTION_START_AS).get(0);

			if (args.containsOption(Constants.OPTION_TOPIC)) {

				topic = args.getOptionValues(Constants.OPTION_TOPIC).get(0);

				if (Constants.OPTION_CONSUMER.equalsIgnoreCase(start_as)) {
					taskExecutor.execute(new Consumer(topic));
				} else if (Constants.OPTION_PRODUCER.equalsIgnoreCase(start_as)) {
					msg = args.getOptionValues(Constants.OPTION_MESSAGE).get(0);
					if (null != msg) {
						taskExecutor.execute(new Producer(topic, msg));
					}
				}
			}
		}

	}
}
