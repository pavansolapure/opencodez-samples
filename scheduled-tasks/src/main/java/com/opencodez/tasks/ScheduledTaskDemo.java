package com.opencodez.tasks;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskDemo {

	//@Scheduled(fixedRate = 1000)
	public void scheduleFixedRateTask() {
		long delay = 2000L;
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Fixed rate task - " + new Date());
	}
	
	//@Scheduled(fixedDelay = 1000)
	public void scheduleFixedDelayTask() {
	    System.out.println("Fixed delay task - " + new Date());
	}
	
	//@Scheduled(fixedDelay = 1000, initialDelay = 5000)
	public void scheduleInitialDelayTask() {
	    System.out.println("Initial delay task - " + new Date());
	}
	
	@Scheduled(cron = "*/10 * * * * *")
	public void scheduleTaskCronExpression() {
		System.out.println("Fixed delay task - " + new Date());
	}
}
