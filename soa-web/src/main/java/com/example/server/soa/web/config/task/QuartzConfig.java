package com.example.server.soa.web.config.task;

import com.example.server.soa.rpc.config.CmsActivityConfig;
import com.example.server.soa.rpc.config.CmsCategoryConfig;
import com.example.server.soa.rpc.config.impl.CmsActivityConfigImpl;
import com.example.server.soa.rpc.config.impl.CmsCategoryConfigImpl;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

@SuppressWarnings("Duplicates")
@Configuration
@Slf4j
public class QuartzConfig {

    /**
     * 任务1配置
     */
    @Bean(initMethod = "init")
    public CmsActivityConfigImpl cmsActivityConfig() {
        return new CmsActivityConfigImpl();
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean jobDetail1(CmsActivityConfig cmsActivityConfig) {
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setConcurrent(false);
        factoryBean.setTargetObject(cmsActivityConfig);
        factoryBean.setTargetMethod("executeUpdateCmsConfig");
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTrigger1(JobDetail jobDetail1) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail1);
        factoryBean.setCronExpression("0 0/2 * * * ?");
        return factoryBean;
    }

    /**
     * 任务2配置
     */
    @Bean(initMethod = "init")
    public CmsCategoryConfigImpl cmsCategoryConfig() {
        return new CmsCategoryConfigImpl();
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean jobDetail2(CmsCategoryConfig cmsCategoryConfig) {
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setConcurrent(false);
        factoryBean.setTargetObject(cmsCategoryConfig);
        factoryBean.setTargetMethod("executeUpdateCmsConfig");
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTrigger2(JobDetail jobDetail2) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail2);
        factoryBean.setCronExpression("0 0/2 * * * ?");
        return factoryBean;
    }

    /**
     * 总配置
     */
    @Bean
    public SchedulerFactoryBean configQuartz(CronTrigger cronTrigger1, CronTrigger cronTrigger2) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(cronTrigger1, cronTrigger2);
        factoryBean.setAutoStartup(true);
        Properties properties = new Properties();
        properties.setProperty("org.quartz.threadPool.threadCount", "2");
        factoryBean.setQuartzProperties(properties);

        log.info("定时任务初始化 开始......");
        try {
            factoryBean.start();
        } catch (Exception e) {
            log.error("scheduler start error, Exception Message:{}", e.getMessage(), e);
        }
        log.info("定时任务初始化 结束......");

        return factoryBean;
    }
}
