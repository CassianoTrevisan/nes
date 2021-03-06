package com.cassiano.config;

import com.cassiano.listener.JobCompletionListener;
import com.cassiano.services.ConfigLoaderService;
import com.cassiano.services.SomeService;
import com.cassiano.step.Processor;
import com.cassiano.step.Reader;
import com.cassiano.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SomeService someService;

    @Autowired
    private ConfigLoaderService configLoaderService;

    @Bean
    public Job processJob() {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(orderStep1())
                .end()
                .build();
    }

    @Bean
    public Step orderStep1() {
        return stepBuilderFactory
                .get("orderStep1")
                .<String, String>chunk(1)
                .reader(new Reader(configLoaderService))
                .processor(new Processor(someService, configLoaderService))
                .writer(new Writer())
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener();
    }

}
