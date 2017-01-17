package jp.kafka.consumer.impl;

import jp.kafka.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class SimpleKafkaConsumer implements KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "test")
    @Override
    public void consume(String message) {
        LOGGER.info("got message : " + message);
    }
}
