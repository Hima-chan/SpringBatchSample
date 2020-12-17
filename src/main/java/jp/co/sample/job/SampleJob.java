package jp.co.sample.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jp.co.sample.listener.JobCompletionNotificationListener;
import jp.co.sample.tasklet.SampleTasklet;

@Configuration
@EnableBatchProcessing
public class SampleJob {

    @Autowired
    SampleTasklet sampleTasklet;

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job taskletSampleJob(JobCompletionNotificationListener listener, Step taskletStep) throws Exception {
        return jobBuilderFactory.get("taskletSampleJob").listener(listener).start(taskletStep).build();
    }

    @Bean
    public Step taskletStep() {
        return stepBuilderFactory.get("sampleTasklet").tasklet(sampleTasklet).build();
    }
}
