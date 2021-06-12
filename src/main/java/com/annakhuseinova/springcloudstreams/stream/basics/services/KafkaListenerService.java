package com.annakhuseinova.springcloudstreams.stream.basics.services;

import com.annakhuseinova.springcloudstreams.stream.basics.bindings.KafkaListenerBinding;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(KafkaListenerBinding.class)
public class KafkaListenerService {

    @StreamListener("input-channel-1")
    public void process(KStream<String, String> input){
        input.foreach((key, value) -> {
            log.info(String.format("Key: %s, Value: %s", key, value));
        });
    }
}
