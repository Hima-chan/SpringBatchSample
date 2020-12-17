package jp.co.sample.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    @Autowired
    MessageSource messageSource;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info(messageSource.getMessage("I00001", null, null));
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info(messageSource.getMessage("I00002", null, null));
    }
}
