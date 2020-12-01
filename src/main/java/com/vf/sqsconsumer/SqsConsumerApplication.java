package com.vf.sqsconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;


@EnableSqs
@SpringBootApplication
public class SqsConsumerApplication{

	public static void main(String[] args) {
		SpringApplication.run(SqsConsumerApplication.class, args);
	}

	/*@Autowired
	SQSUtil util;

	@Override
	public void run(String... args) throws Exception {
		util.readMessage();
	}*/
}
