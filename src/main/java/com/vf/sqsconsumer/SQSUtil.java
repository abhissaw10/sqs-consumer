package com.vf.sqsconsumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SQSUtil {

    @SqsListener("${sqs.url}")
    public void readMessage(String message){
        System.out.println("Reading the message "+message);
    }

}
