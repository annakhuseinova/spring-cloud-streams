package com.annakhuseinova.springcloudstreams.kafka.controller;

import com.annakhuseinova.springcloudstreams.kafka.IncomingMessage;
import com.annakhuseinova.springcloudstreams.kafka.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaMessageController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/post")
    public String sendMessageToKafka(@RequestBody IncomingMessage message){
        kafkaProducerService.sendMessage(message.getTopic(), message.getKey(), message.getValue());
        return String.format("Success - Message for key %s is sent to Kafka Topic: %s", message.getKey(),
                message.getTopic());
    }
}
