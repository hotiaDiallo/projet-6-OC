package com.ib.batch;

import com.ib.config.LoanClient;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableBatchProcessing
public class AppConfiguration {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public JobTasklet jobTasklet(){
        return new JobTasklet();
    }

    @Bean
    public Step stepTask(){
        return steps.get("stepTask")
                .tasklet(new JobTasklet())
                .build();
    }

    @Bean
    public Job demoJob(){
        return jobs.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(stepTask())
                .build();
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
