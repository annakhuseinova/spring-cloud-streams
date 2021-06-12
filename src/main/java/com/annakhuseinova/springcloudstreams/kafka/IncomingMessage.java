package com.annakhuseinova.springcloudstreams.kafka;

import lombok.Data;

@Data
public class IncomingMessage {

    private String topic;
    private String key;
    private String value;
}
