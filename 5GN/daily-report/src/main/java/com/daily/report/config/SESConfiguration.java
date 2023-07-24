package com.daily.report.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SESConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService(){
        BasicSessionCredentials credentials = new BasicSessionCredentials(env.getProperty("AWS.ACCESS-KEY"),env.getProperty("AWS.SECRET-KEY"),env.getProperty("AWS.Session-Token"));
        return AmazonSimpleEmailServiceClientBuilder
                .standard()
                .withRegion(env.getProperty("AWS.REGION"))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
