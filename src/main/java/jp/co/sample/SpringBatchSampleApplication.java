package jp.co.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBatchSampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBatchSampleApplication.class, args);

        System.exit(SpringApplication.exit(context));
    }

}
