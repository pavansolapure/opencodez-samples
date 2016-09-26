/**
 * 
 */
package com.opencodez.quartz.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import com.opencodez.configuration.ConfigureQuartz;
import com.opencodez.util.AppLogger;

/**
 * @author pavan.solapure
 *
 */
@Component
@DisallowConcurrentExecution
public class JobWithCronTrigger implements Job {

	private final static AppLogger logger = AppLogger.getInstance();

	@Value("${cron.frequency.jobwithcrontrigger}")
	private String frequency;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		logger.info("Running JobWithCronTrigger | frequency {}", frequency);
	}

	@Bean(name = "jobWithCronTriggerBean")
	public JobDetailFactoryBean sampleJob() {
		return ConfigureQuartz.createJobDetail(this.getClass());
	}

	@Bean(name = "jobWithCronTriggerBeanTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithCronTriggerBean") JobDetail jobDetail) {
		return ConfigureQuartz.createCronTrigger(jobDetail, frequency);
	}
}
