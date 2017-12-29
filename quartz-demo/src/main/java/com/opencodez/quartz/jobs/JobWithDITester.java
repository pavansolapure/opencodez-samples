package com.opencodez.quartz.jobs;

import javax.inject.Inject;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import com.opencodez.configuration.ConfigureQuartz;
import com.opencodez.util.AppLogger;

@Component
@DisallowConcurrentExecution
public class JobWithDITester implements Job  {
	
	private final static AppLogger logger = AppLogger.getInstance();

	@Value("${cron.frequency.jobwithditest}")
	private String frequency;

	@Inject
	private ArbitraryDependency fieldInjectDependency;
	

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		logger.info("Running JobWithDITester | frequency {}", frequency);
		if (null != fieldInjectDependency) {
			logger.info("ArbitraryDependency = " + fieldInjectDependency.toString());
		}
	}
	
	@Bean(name = "jobWithDITesterBean")
	public JobDetailFactoryBean sampleJob() {
		return ConfigureQuartz.createJobDetail(this.getClass());
	}
	
	@Bean(name = "jobWithDITesterBeanTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithDITesterBean") JobDetailFactoryBean jdfb ) {
		return ConfigureQuartz.createCronTrigger(jdfb.getObject(), frequency);
	}

}
