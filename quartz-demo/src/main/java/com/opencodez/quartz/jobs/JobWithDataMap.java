/**
 * 
 */
package com.opencodez.quartz.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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
public class JobWithDataMap implements Job {
	
private final static AppLogger logger = AppLogger.getInstance();
	
	@Value("${cron.frequency.jobwithdatamap}")
    private String frequency;
	
	JobDataMap jMap = new JobDataMap();

	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		logger.info("Running JobWithDataMap | frequency {}", frequency);
		JobDataMap dataMap = jobContext.getJobDetail().getJobDataMap();
		String key1 = dataMap.get("key1").toString();
		String key2 = dataMap.get("key2").toString();
		logger.info("Running JobWithDataMap | Key1 = {}, Key2 = {}", key1, key2 );
	}
	
	@Bean(name = "jobWithDataMapBean")
    public JobDetailFactoryBean sampleJob() {
		JobDetailFactoryBean jBean = ConfigureQuartz.createJobDetail(this.getClass());
		jMap.put("key1", "value1");
		jMap.put("key2", "value2");
		jBean.setJobDataMap(jMap);
        return jBean;
    }

    @Bean(name = "jobWithDataMapTrigger")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithDataMapBean") JobDetail jobDetail) {
    	return ConfigureQuartz.createCronTrigger(jobDetail,frequency);
    }

}
