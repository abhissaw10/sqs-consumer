package com.vf.sqsconsumer;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {

    @Value("${sqs.url}")
    private String sqsUrl;

    @Value("${aws.accessKey}")
    private String awsAccessKey;

    @Value("${aws.secretKey}")
    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;


    @Bean
    AWSStaticCredentialsProvider awsCredentialsProvider(){
        return new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(awsAccessKey, awsSecretKey)
        );
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        QueueMessagingTemplate template = new QueueMessagingTemplate(amazonSQSAsync);
        return  template;
    }

    @Bean
    public AmazonSQS amazonSQSAsync(AWSStaticCredentialsProvider awsStaticCredentialsProvider) {
        return AmazonSQSClientBuilder
                .standard()
                .withRegion(awsRegion)
                .withCredentials(awsStaticCredentialsProvider).build();

    }

}
