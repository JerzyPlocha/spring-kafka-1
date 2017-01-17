package jp.kafka.producer.impl;

import jp.kafka.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class SimpleKafkaProducer implements KafkaProducer {

    private static Logger LOGGER = LoggerFactory.getLogger(SimpleKafkaProducer.class);

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Value("${kafka.mytopic}")
    private String topic;

    @Override
    public void produce(String msg) {
        if (kafkaTemplate == null) {
            LOGGER.error("KAFKA TEMPLATE IS NULL");
        } else {
            LOGGER.info("producing. topic: " + topic + " " + msg);
            kafkaTemplate.send(topic, msg);
        }
    }
}
